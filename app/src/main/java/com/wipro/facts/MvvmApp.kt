package com.wipro.facts

import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.wipro.facts.di.component.DaggerAppComponent
import com.wipro.facts.utils.AppLogger
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class MvvmApp : Application(), HasAndroidInjector {

    @set:Inject
    var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>? = null


    override fun androidInjector(): AndroidInjector<Any>? {
        return dispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

        AppLogger.init()

        AndroidNetworking.initialize(applicationContext)
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY)
        }

    }
}
