package com.wipro.facts.ui.home.canada



class FactsEmptyItemViewModel(private val factEmptyItemViewModelListener: FactEmptyItemViewModelListener) {

    fun onRetryClick() {
        factEmptyItemViewModelListener.onRetryClick()
    }

    interface FactEmptyItemViewModelListener {

        fun onRetryClick()
    }
}
