import com.wipro.facts.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector
    internal abstract fun bindFactsFragment(): FactsFragment

    @ContributesAndroidInjector
    internal abstract fun bindSplashActivity(): SplashActivity
}
