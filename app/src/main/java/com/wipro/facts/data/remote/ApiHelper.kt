import io.reactivex.Single


interface ApiHelper {

    val canadaApiCall: Single<FactsOutputModel>
}
