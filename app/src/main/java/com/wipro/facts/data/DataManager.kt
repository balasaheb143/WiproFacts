package com.wipro.facts.data

import com.wipro.facts.data.local.prefs.PreferencesHelper
import com.wipro.facts.data.remote.ApiHelper

/**
 * Created by amitshekhar on 07/07/17.
 */

interface DataManager : PreferencesHelper, ApiHelper {


    fun updateApiHeader(userId: Long?, accessToken: String?)


}
