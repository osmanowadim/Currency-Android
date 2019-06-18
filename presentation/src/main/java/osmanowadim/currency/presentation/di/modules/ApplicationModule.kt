package osmanowadim.currency.presentation.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import osmanowadim.currency.data.CurrencyCacheImpl
import osmanowadim.currency.data.cache.dao.CurrencyDao
import osmanowadim.currency.data.cache.dao.ExchangeDao
import osmanowadim.currency.data.cache.entity.mapper.CurrencyCachedEntityMapper
import osmanowadim.currency.data.cache.entity.mapper.ExchangeCachedEntityMapper
import osmanowadim.currency.data.entity.mapper.CurrencyEntityDataMapper
import osmanowadim.currency.data.executor.JobExecutor
import osmanowadim.currency.data.remote.entity.mapper.RemoteCurrencyEntityMapper
import osmanowadim.currency.data.remote.impl.CurrencyRemoteImpl
import osmanowadim.currency.data.remote.services.CurrencyService
import osmanowadim.currency.data.repository.CurrencyCache
import osmanowadim.currency.data.repository.CurrencyDataRepository
import osmanowadim.currency.data.repository.CurrencyDataStore
import osmanowadim.currency.data.repository.CurrencyRemote
import osmanowadim.currency.data.source.CurrencyDataStoreFactory
import osmanowadim.currency.data.source.CurrencyRemoteDataStore
import osmanowadim.currency.domain.executor.PostExecutionThread
import osmanowadim.currency.domain.executor.ThreadExecutor
import osmanowadim.currency.domain.repository.CurrencyRepository
import osmanowadim.currency.domain.scopes.PerApplication
import osmanowadim.currency.presentation.UIThread

@Module
open class ApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context = application

    @Provides
    @PerApplication
    fun provideExecutor(): ThreadExecutor = JobExecutor()

    @Provides
    @PerApplication
    fun providePostExecutor(): PostExecutionThread = UIThread()

    @Provides
    @PerApplication
    fun provideCurrencyRepository(
        factory: CurrencyDataStoreFactory,
        mapper: CurrencyEntityDataMapper
    ): CurrencyRepository = CurrencyDataRepository(factory, mapper)

    @Provides
    @PerApplication
    fun provideCurrencyRemote(currencyService: CurrencyService, mapper: RemoteCurrencyEntityMapper)
            : CurrencyRemote = CurrencyRemoteImpl(currencyService, mapper)

    @Provides
    @PerApplication
    fun provideCurrencyDataStore(remote: CurrencyRemote)
            : CurrencyDataStore = CurrencyRemoteDataStore(remote)

    @Provides
    @PerApplication
    fun provideCurrencyCache(
        currencyDao: CurrencyDao,
        exchangeDao: ExchangeDao,
        currencyMapper: CurrencyCachedEntityMapper,
        exchangeMapper: ExchangeCachedEntityMapper
    ): CurrencyCache = CurrencyCacheImpl(currencyDao, exchangeDao, currencyMapper, exchangeMapper)

}
