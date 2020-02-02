package com.wipro.facts.ui.feed

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.wipro.facts.ui.home.canada.FactsFragment


class FeedPagerAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    private var mTabCount: Int = 1

    init {
        this.mTabCount = 1
    }

    override fun getCount(): Int {
        return mTabCount
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FactsFragment.newInstance()
            else -> null!!
        }
    }
}
