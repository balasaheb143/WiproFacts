package com.wipro.facts.data.remote

import io.reactivex.Single

/**
 * Created by amitshekhar on 07/07/17.
 */

interface ApiHelper {
    val apiHeader: ApiHeader

    val canadaApiCall: Single<FactsOutputModel>

}
