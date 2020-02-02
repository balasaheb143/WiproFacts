package com.wipro.facts.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayout
import com.wipro.facts.ui.feed.FeedPagerAdapter
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
    var mPagerAdapter: FeedPagerAdapter? = null
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


        mActivityFeedBinding!!.feedViewPager.adapter = mPagerAdapter

        mActivityFeedBinding!!.tabLayout.addTab(mActivityFeedBinding!!.tabLayout.newTab().setText(getString(R.string.blog)))
        mActivityFeedBinding!!.tabLayout.addTab(mActivityFeedBinding!!.tabLayout.newTab().setText(getString(R.string.open_source)))

        mActivityFeedBinding!!.feedViewPager.offscreenPageLimit = mActivityFeedBinding!!.tabLayout.tabCount

        mActivityFeedBinding!!.feedViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(mActivityFeedBinding!!.tabLayout))

        mActivityFeedBinding!!.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab) {

            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                mActivityFeedBinding!!.feedViewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
        })
    }


    companion object {

        fun newIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}
