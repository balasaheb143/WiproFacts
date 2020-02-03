package com.wipro.facts.ui.home.canada

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wipro.facts.data.DataManager
import com.wipro.facts.data.remote.RowsItem
import com.wipro.facts.ui.base.BaseViewModel
import com.wipro.facts.utils.rx.SchedulerProvider


class FactsViewModel(
    dataManager: DataManager,
    schedulerProvider: SchedulerProvider
) : BaseViewModel<FactsNavigator>(dataManager, schedulerProvider) {

    private val rowsItemLiveData: MutableLiveData<List<RowsItem>> = MutableLiveData()
    private val pageTitle: MutableLiveData<String> = MutableLiveData()


    fun fetchCanadaRows() {
        setIsLoading(true)
        compositeDisposable.add(dataManager.canadaApiCall
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui()).map {
                it.rows =
                    it.rows.filter { rowsItem -> rowsItem.imageHref != null && rowsItem.title != null && rowsItem.description != null }
                return@map it
            }
            .subscribe({ canadaInputModel ->
                if (canadaInputModel?.rows != null) {
                    rowsItemLiveData.value = canadaInputModel.rows
                    pageTitle.value = canadaInputModel.title
                }
                setIsLoading(false)
            }, { throwable ->
                setIsLoading(false)
                setError(error = throwable)
            })
        )
    }

    fun getRowsItemLiveData(): LiveData<List<RowsItem>> {
        return rowsItemLiveData
    }

    fun getPageTitle(): LiveData<String> {
        return pageTitle
    }
}
