package com.wipro.facts.di.module

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.wipro.facts.data.AppDataManager
import com.wipro.facts.data.DataManager
import com.wipro.facts.data.remote.ApiHelper
import com.wipro.facts.data.remote.AppApiHelper
import com.wipro.facts.di.ApiInfo
import com.wipro.facts.utils.rx.AppSchedulerProvider
import com.wipro.facts.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }

    @Provides
    @ApiInfo
    internal fun provideApiKey(): String {
        return ""
    }


    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }



    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }



    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

}
