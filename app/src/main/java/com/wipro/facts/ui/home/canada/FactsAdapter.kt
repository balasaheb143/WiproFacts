package com.wipro.facts.ui.home.canada

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wipro.facts.data.remote.RowsItem
import com.wipro.facts.databinding.RowFactViewBinding
import com.wipro.facts.ui.base.BaseViewHolder

class FactsAdapter(private val rowsItems: MutableList<RowsItem>?) :
        RecyclerView.Adapter<BaseViewHolder>() {


    override fun getItemCount(): Int {
        return rowsItems!!.size
    }


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val itemFactViewBinding = RowFactViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
        )
       return FactsViewHolder(itemFactViewBinding)
    }

    fun addItems(rowsItems: List<RowsItem>) {
        clearItems()
        this.rowsItems?.addAll(rowsItems)
        notifyDataSetChanged()
    }

    fun clearItems() {
        rowsItems?.clear()
    }


    inner class FactsViewHolder(private val itemFactViewBinding: RowFactViewBinding) :
            BaseViewHolder(itemFactViewBinding.root) {

        private var factsItemViewModel: FactsItemViewModel? = null

        override fun onBind(position: Int) {
            val rowsItem = rowsItems!![position]
            factsItemViewModel = FactsItemViewModel(rowsItem)
            itemFactViewBinding.viewModel = factsItemViewModel
            itemFactViewBinding.executePendingBindings()
        }

    }
}