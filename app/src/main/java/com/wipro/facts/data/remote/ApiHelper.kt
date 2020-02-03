package com.wipro.facts.data.remote

import io.reactivex.Single


interface ApiHelper {
    val apiHeader: ApiHeader

    val canadaApiCall: Single<FactsOutputModel>

}
