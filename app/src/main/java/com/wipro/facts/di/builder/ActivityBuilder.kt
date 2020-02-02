package com.wipro.facts.di.builder

import com.wipro.facts.ui.feed.FeedActivityModule
import com.wipro.facts.ui.home.HomeActivity
import com.wipro.facts.ui.home.canada.FactsFragmentProvider
import com.wipro.facts.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by amitshekhar on 14/09/17.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [FeedActivityModule::class, FactsFragmentProvider::class])
    internal abstract fun bindFeedActivity(): HomeActivity


    @ContributesAndroidInjector
    internal abstract fun bindSplashActivity(): SplashActivity
}
