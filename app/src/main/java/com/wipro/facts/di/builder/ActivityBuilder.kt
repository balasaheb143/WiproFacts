package com.wipro.facts.di.builder

import com.wipro.facts.ui.home.HomeActivity
import com.wipro.facts.ui.home.canada.FactsFragmentProvider
import com.wipro.facts.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [FactsFragmentProvider::class])
    internal abstract fun bindFeedActivity(): HomeActivity


    @ContributesAndroidInjector
    internal abstract fun bindSplashActivity(): SplashActivity
}
