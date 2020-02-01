package com.wipro.facts.data.remote
import io.reactivex.Single


interface ApiHelper {

    val canadaApiCall: Single<FactsOutputModel>
}
