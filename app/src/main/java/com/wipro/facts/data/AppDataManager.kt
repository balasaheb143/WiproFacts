package com.wipro.facts.data

import android.content.Context
import com.google.gson.Gson
import com.wipro.facts.data.local.prefs.PreferencesHelper
import com.wipro.facts.data.remote.ApiHeader
import com.wipro.facts.data.remote.ApiHelper
import com.wipro.facts.data.remote.FactsOutputModel
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by amitshekhar on 07/07/17.
 */
@Singleton
class AppDataManager @Inject
constructor(private val mContext: Context, private val mPreferencesHelper: PreferencesHelper, private val mApiHelper: ApiHelper, private val mGson: Gson) : DataManager {

    override var accessToken: String?
        get() = mPreferencesHelper.accessToken
        set(accessToken) {
            mPreferencesHelper.accessToken = accessToken
            mApiHelper.apiHeader.protectedApiHeader.accessToken = accessToken
        }


    override val apiHeader: ApiHeader
        get() = mApiHelper.apiHeader


    override val canadaApiCall: Single<FactsOutputModel>
        get() = mApiHelper.canadaApiCall


    override var currentUserId: Long?
        get() = mPreferencesHelper.currentUserId
        set(userId) {
            mPreferencesHelper.currentUserId = userId
        }


    override fun updateApiHeader(userId: Long?, accessToken: String?) {
        mApiHelper.apiHeader?.protectedApiHeader?.userId = userId
        mApiHelper.apiHeader?.protectedApiHeader?.accessToken = accessToken
    }


    companion object {

        private val TAG = "AppDataManager"
    }
}
