package com.wipro.facts.di.module

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.wipro.facts.data.AppDataManager
import com.wipro.facts.data.DataManager
import com.wipro.facts.data.local.prefs.AppPreferencesHelper
import com.wipro.facts.data.local.prefs.PreferencesHelper
import com.wipro.facts.data.remote.ApiHeader
import com.wipro.facts.data.remote.ApiHelper
import com.wipro.facts.data.remote.AppApiHelper
import com.wipro.facts.di.ApiInfo
import com.wipro.facts.di.DatabaseInfo
import com.wipro.facts.di.PreferenceInfo
import com.wipro.facts.utils.AppConstants
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
    @DatabaseInfo
    internal fun provideDatabaseName(): String {
        return AppConstants.DB_NAME
    }


    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @PreferenceInfo
    internal fun providePreferenceName(): String {
        return AppConstants.PREF_NAME
    }

    @Provides
    @Singleton
    internal fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

    @Provides
    @Singleton
    internal fun provideProtectedApiHeader(
        @ApiInfo apiKey: String,
        preferencesHelper: PreferencesHelper
    ): ApiHeader.ProtectedApiHeader {
        return ApiHeader.ProtectedApiHeader(
            apiKey,
            preferencesHelper.currentUserId,
            preferencesHelper.accessToken
        )
    }

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

}
