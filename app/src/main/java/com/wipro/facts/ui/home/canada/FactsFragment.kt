package com.wipro.facts.ui.home.canada
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.wipro.facts.ui.base.BaseFragment
import com.wipro.facts.R
import com.wipro.facts.BR
import com.wipro.facts.ViewModelProviderFactory
import com.wipro.facts.databinding.FragmentFactsBinding
import javax.inject.Inject


class FactsFragment : BaseFragment<FragmentFactsBinding, FactsViewModel>(), FactsNavigator, FactsAdapter.FactAdapterListener {

    @set:Inject
    var mFactsAdapter: FactsAdapter? = null
    var fragmentFactsBinding: FragmentFactsBinding? = null
    @set:Inject
    var mLayoutManager: LinearLayoutManager? = null
    @set:Inject
    var factory: ViewModelProviderFactory? = null
    private var mFactsViewModel: FactsViewModel? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_facts

    override val viewModel: FactsViewModel
        get() {
            mFactsViewModel = ViewModelProviders.of(this, factory).get(FactsViewModel::class.java)
            return mFactsViewModel as FactsViewModel
        }

    override fun handleError(throwable: Throwable) {
        // handle error
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFactsViewModel!!.navigator = this
        mFactsAdapter!!.setListener(this)
    }

    override fun onRetryClick() {
        mFactsViewModel!!.fetchCanadaRows()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentFactsBinding = viewDataBinding
        setUp()
    }


    private fun setUp() {
        mLayoutManager?.orientation = LinearLayoutManager.VERTICAL
        fragmentFactsBinding?.canadaRecyclerView?.layoutManager = mLayoutManager
        fragmentFactsBinding?.canadaRecyclerView?.itemAnimator = DefaultItemAnimator()
        fragmentFactsBinding?.canadaRecyclerView?.adapter = mFactsAdapter
        mFactsViewModel?.getRowsItemLiveData()?.observe(viewLifecycleOwner, Observer { t -> mFactsAdapter?.addItems(t) })
    }

    companion object {

        fun newInstance(): FactsFragment {
            val args = Bundle()
            val fragment = FactsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
