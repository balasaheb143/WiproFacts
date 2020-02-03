package com.wipro.facts.utils

import android.content.Context
import android.net.ConnectivityManager
import androidx.fragment.app.FragmentActivity

object NetworkUtils {

    fun isNetworkConnected(context: FragmentActivity?): Boolean {
        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}// This class is not publicly instantiable
