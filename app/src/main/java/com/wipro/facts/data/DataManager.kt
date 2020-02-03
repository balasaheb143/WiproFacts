package com.wipro.facts.data

import com.wipro.facts.data.local.prefs.PreferencesHelper
import com.wipro.facts.data.remote.ApiHelper


interface DataManager : PreferencesHelper, ApiHelper {


    fun updateApiHeader(userId: Long?, accessToken: String?)


}
