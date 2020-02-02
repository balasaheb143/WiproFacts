package com.wipro.facts.data.remote

import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by amitshekhar on 07/07/17.
 */

@Singleton
class AppApiHelper @Inject
constructor(override val apiHeader: ApiHeader) : ApiHelper {


    override val canadaApiCall: Single<FactsOutputModel>
        get() = Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_CANADA)
            .addHeaders(apiHeader.protectedApiHeader)
            .build()
            .getObjectSingle(FactsOutputModel::class.java)
}
