package com.wipro.facts.data.remote

import ApiHelper
import FactsOutputModel
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppApiHelper @Inject
constructor() : ApiHelper {

    override val canadaApiCall: Single<FactsOutputModel>
        get() = Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_CANADA)
            .build()
            .getObjectSingle(FactsOutputModel::class.java)
}
