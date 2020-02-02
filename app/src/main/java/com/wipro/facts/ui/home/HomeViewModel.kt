package com.wipro.facts.ui.home

import com.wipro.facts.data.DataManager
import com.wipro.facts.ui.base.BaseViewModel
import com.wipro.facts.utils.rx.SchedulerProvider

class HomeViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<Any>(dataManager, schedulerProvider)
