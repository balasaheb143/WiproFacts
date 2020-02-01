import com.wipro.facts.ui.home.HomeActivity
import com.wipro.facts.ui.home.canada.FactsFragment
import com.wipro.facts.ui.home.canada.FactsFragmentProvider
import com.wipro.facts.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [FactsFragmentProvider::class])
    internal abstract fun bindFactsFragment(): FactsFragment

    @ContributesAndroidInjector
    internal abstract fun bindSplashActivity(): SplashActivity
}
