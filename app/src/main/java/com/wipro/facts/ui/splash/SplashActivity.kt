package com.wipro.facts.ui.splash

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.wipro.facts.BR
import com.wipro.facts.R
import com.wipro.facts.ViewModelProviderFactory
import com.wipro.facts.databinding.ActivitySplashBinding
import com.wipro.facts.ui.base.BaseActivity
import com.wipro.facts.ui.login.LoginActivity
import com.wipro.facts.ui.main.MainActivity
import javax.inject.Inject


class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(), SplashNavigator {
    override fun onFragmentDetached(tag: String) {
    }

    @set:Inject
    var factory: ViewModelProviderFactory? = null

    private var mSplashViewModel: SplashViewModel? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_splash

    override val viewModel: SplashViewModel
        get() {
            mSplashViewModel = ViewModelProviders.of(this, factory).get(SplashViewModel::class.java)
            return mSplashViewModel!!
        }

    override fun openLoginActivity() {
        val intent = LoginActivity.newIntent(this@SplashActivity)
        startActivity(intent)
        finish()
    }

    override fun openMainActivity() {
        val intent = MainActivity.newIntent(this@SplashActivity)
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSplashViewModel!!.navigator = this
        mSplashViewModel!!.startSeeding()
    }
}
