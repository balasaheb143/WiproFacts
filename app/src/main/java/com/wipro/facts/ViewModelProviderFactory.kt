package com.wipro.facts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wipro.facts.data.DataManager
import com.wipro.facts.ui.home.HomeViewModel
import com.wipro.facts.ui.home.canada.FactsViewModel
import com.wipro.facts.ui.splash.SplashViewModel
import com.wipro.facts.utils.rx.SchedulerProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelProviderFactory @Inject
constructor(
    private val dataManager: DataManager,
    private val schedulerProvider: SchedulerProvider
) : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(
                dataManager,
                schedulerProvider
            ) as T
            modelClass.isAssignableFrom(SplashViewModel::class.java) -> SplashViewModel(
                dataManager,
                schedulerProvider
            ) as T
            modelClass.isAssignableFrom(FactsViewModel::class.java) -> FactsViewModel(
                dataManager,
                schedulerProvider
            ) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}