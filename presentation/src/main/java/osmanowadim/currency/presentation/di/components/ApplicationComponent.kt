package osmanowadim.currency.presentation.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import osmanowadim.currency.presentation.di.modules.binding.ActivityBindingModule
import osmanowadim.currency.domain.scopes.PerApplication
import osmanowadim.currency.presentation.CurrencyApplication
import osmanowadim.currency.presentation.di.modules.ApiModule
import osmanowadim.currency.presentation.di.modules.ApplicationModule
import osmanowadim.currency.presentation.di.modules.DatabaseModule

/**
 * A component whose lifetime is the life of the application.
 */
@PerApplication
@Component(
    modules = [AndroidSupportInjectionModule::class, ApplicationModule::class,
        DatabaseModule::class, ApiModule::class, ActivityBindingModule::class]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: CurrencyApplication)

}
