package com.wipro.facts.ui.feed

import com.wipro.facts.ui.home.HomeActivity
import dagger.Module
import dagger.Provides

/**
 * Created by amitshekhar on 14/09/17.
 */
@Module
class FeedActivityModule {

    @Provides
    internal fun provideFeedPagerAdapter(activity: HomeActivity): FeedPagerAdapter {
        return FeedPagerAdapter(activity.supportFragmentManager)
    }

}
