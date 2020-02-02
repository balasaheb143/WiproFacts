package com.wipro.facts.ui.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wipro.facts.data.DataManager
import com.wipro.facts.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference


abstract class BaseViewModel<N>(
    val dataManager: DataManager,
    val schedulerProvider: SchedulerProvider
) : ViewModel() {

    val isLoading = ObservableBoolean()

    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val error: MutableLiveData<Throwable> = MutableLiveData()

    private lateinit var mNavigator: WeakReference<N?>

    var navigator: N?
        get() = mNavigator?.get()
        set(navigator) {
            this.mNavigator = WeakReference(navigator)
        }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }

    fun setError(error: Throwable) {
        this.error.value = error
    }
}
