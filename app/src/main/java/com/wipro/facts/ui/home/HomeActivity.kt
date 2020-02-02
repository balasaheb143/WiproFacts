package com.wipro.facts.ui.home
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.wipro.facts.BR
import com.wipro.facts.R
import com.wipro.facts.ViewModelProviderFactory
import com.wipro.facts.databinding.ActivityHomeBinding
import com.wipro.facts.ui.base.BaseActivity
import javax.inject.Inject


class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {
    override fun onFragmentDetached(tag: String) {
    }

    @set:Inject
    var factory: ViewModelProviderFactory? = null
    private var mActivityFeedBinding: ActivityHomeBinding? = null
    private var mHomeViewModel: HomeViewModel? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_home

    override val viewModel: HomeViewModel
        get() {
            mHomeViewModel = ViewModelProviders.of(this, factory).get(HomeViewModel::class.java)
            return mHomeViewModel as HomeViewModel
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityFeedBinding = viewDataBinding
        setUp()
    }

    private fun setUp() {
        setSupportActionBar(mActivityFeedBinding!!.toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }


    }
}
