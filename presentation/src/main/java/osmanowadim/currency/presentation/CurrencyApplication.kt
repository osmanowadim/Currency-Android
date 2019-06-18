package osmanowadim.currency.presentation

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import osmanowadim.currency.presentation.di.components.ApplicationComponent
import osmanowadim.currency.presentation.di.components.DaggerApplicationComponent
import java.util.*
import javax.inject.Inject


class CurrencyApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    private val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        injectMembers()
    }

    private fun injectMembers() {
        appComponent.inject(this)
    }

}
