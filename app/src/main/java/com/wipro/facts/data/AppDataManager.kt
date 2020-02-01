import android.content.Context
import com.google.gson.Gson
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject
constructor(
    private val mContext: Context,
    private val mApiHelper: ApiHelper,
    private val mGson: Gson
) : DataManager {


    override val canadaApiCall: Single<FactsOutputModel>
        get() = mApiHelper.canadaApiCall


    override fun updateApiHeader() {
    }


    companion object {

        private val TAG = "AppDataManager"
    }
}
