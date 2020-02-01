
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.framework.mvvm.databinding.ItemFactViewBinding
import com.wipro.facts.databinding.ItemFactEmptyViewBinding
import com.wipro.facts.ui.home.canada.FactsEmptyItemViewModel


class FactsAdapter(private val rowsItems: MutableList<RowsItem>?) : RecyclerView.Adapter<BaseViewHolder>() {

    private var factAdapterListener: FactAdapterListener? = null

    override fun getItemCount(): Int {
        return if (rowsItems != null && rowsItems.size > 0) {
            rowsItems.size
        } else {
            1
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (rowsItems != null && rowsItems.isNotEmpty()) {
            VIEW_TYPE_NORMAL
        } else {
            VIEW_TYPE_EMPTY
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            VIEW_TYPE_NORMAL -> {
                val itemFactViewBinding = ItemFactViewBinding.inflate(LayoutInflater.from(parent.context),
                        parent, false)
                FactsViewHolder(itemFactViewBinding)
            }
            else -> {
                val itemFactEmptyViewBinding = ItemFactEmptyViewBinding.inflate(LayoutInflater.from(parent.context),
                        parent, false)
                EmptyViewHolder(itemFactEmptyViewBinding)
            }
        }
    }

    fun addItems(rowsItems: List<RowsItem>) {
        this.rowsItems?.addAll(rowsItems)
        notifyDataSetChanged()
    }

    fun clearItems() {
        rowsItems!!.clear()
    }

    fun setListener(listener: FactAdapterListener) {
        this.factAdapterListener = listener
    }

    interface FactAdapterListener {

        fun onRetryClick()
    }

    inner class FactsViewHolder(private val itemFactViewBinding: ItemFactViewBinding) : BaseViewHolder(itemFactViewBinding.root) {

        private var factsItemViewModel: FactsItemViewModel? = null

        override fun onBind(position: Int) {
            val rowsItem = rowsItems!![position]
            factsItemViewModel = FactsItemViewModel(rowsItem)
            itemFactViewBinding.viewModel = factsItemViewModel
            itemFactViewBinding.executePendingBindings()
        }

    }

    inner class EmptyViewHolder(private val itemFactEmptyViewBinding: ItemFactEmptyViewBinding) : BaseViewHolder(itemFactEmptyViewBinding.root), FactsEmptyItemViewModel.FactEmptyItemViewModelListener {

        override fun onBind(position: Int) {
            val emptyItemViewModel = FactsEmptyItemViewModel(this)
            itemFactEmptyViewBinding.viewModel = emptyItemViewModel
        }

        override fun onRetryClick() {
            factAdapterListener!!.onRetryClick()
        }
    }

    companion object {

        const val VIEW_TYPE_EMPTY = 0

        const val VIEW_TYPE_NORMAL = 1
    }
}