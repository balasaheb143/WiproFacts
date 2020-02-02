package com.wipro.facts.di.component

import android.app.Application
import com.wipro.facts.MvvmApp
import com.wipro.facts.di.builder.ActivityBuilder
import com.wipro.facts.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by amitshekhar on 07/07/17.
 */
@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent {

    fun inject(app: MvvmApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
