package osmanowadim.currency.presentation.di.modules

import dagger.Module
import dagger.Provides
import osmanowadim.currency.data.remote.ServiceProvider
import osmanowadim.currency.data.remote.services.CurrencyService
import osmanowadim.currency.domain.scopes.PerApplication


@Module
class ApiModule {

    @Provides
    @PerApplication
    fun provideCurrencyService(serviceProvider: ServiceProvider)
            : CurrencyService = serviceProvider.provide(CurrencyService::class.java)

}
