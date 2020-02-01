package com.wipro.facts.ui.home.canada
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FactsFragmentProvider {

    @ContributesAndroidInjector(modules = [FactsFragmentModule::class])
    internal abstract fun provideCanadaFragmentFactory(): FactsFragment
}
