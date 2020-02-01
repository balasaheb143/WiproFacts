import androidx.recyclerview.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides
import java.util.*

@Module
class FactsFragmentModule {

    @Provides
    internal fun provideCanadaAdapter(): FactsAdapter {
        return FactsAdapter(ArrayList())
    }

    @Provides
    internal fun provideLinearLayoutManager(factsFragment: FactsFragment): LinearLayoutManager {
        return LinearLayoutManager(factsFragment.activity)
    }
}
