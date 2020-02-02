package com.wipro.facts.ui.splash

import com.wipro.facts.data.DataManager
import com.wipro.facts.ui.base.BaseViewModel
import com.wipro.facts.utils.rx.SchedulerProvider

/**
 * Created by amitshekhar on 08/07/17.
 */

class SplashViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<SplashNavigator>(dataManager, schedulerProvider) {


    private fun decideNextActivity() {
        navigator?.openMainActivity()
    }
}
