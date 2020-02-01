package com.wipro.facts.ui.home

import SchedulerProvider
import com.wipro.facts.data.DataManager
import com.wipro.facts.ui.base.BaseViewModel

class HomeViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<Any>(dataManager, schedulerProvider)
