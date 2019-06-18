package osmanowadim.currency.data.repository

import android.annotation.SuppressLint
import io.reactivex.Single
import osmanowadim.currency.data.entity.CurrencyEntity
import osmanowadim.currency.data.entity.ExchangeEntity
import osmanowadim.currency.data.entity.mapper.CurrencyEntityDataMapper
import osmanowadim.currency.data.source.CurrencyDataStoreFactory
import osmanowadim.currency.domain.interactor.Params
import osmanowadim.currency.domain.model.Currency
import osmanowadim.currency.domain.model.Exchange
import osmanowadim.currency.domain.repository.CurrencyRepository
import javax.inject.Inject

class CurrencyDataRepository @Inject constructor(
    private val factory: CurrencyDataStoreFactory,
    private val mapper: CurrencyEntityDataMapper
) : CurrencyRepository {

    override fun getAllLocalCurrencies(): Single<List<Currency>> {
        return factory.retrieveCacheDataStore().getAllCurrencies().flatMap { allCurrencies ->
            Single.create<List<Currency>> {
                it.onSuccess(allCurrencies.map(mapper::transformToCurrency)
                    .sortedBy { currency -> currency.code })
            }
        }
    }

    override fun getExchangeForCurrency(params: Params?): Single<Exchange> {
        return factory.retrieveCacheDataStore()
            .getExchangeForCurrency(mapper.transformToEntity(params).id)
            .flatMap { exchange ->
                Single.create<Exchange> { it.onSuccess(mapper.transformFromExchangeEntity(exchange)) }
            }
    }

    override fun getAllCurrencies(): Single<List<Currency>> {
        return factory.retrieveRemoteDataStore().getAllCurrencies().flatMap { list ->
            val currencies = list.map(mapper::transformToCurrencyEntity)
            saveCurrenciesToDB(currencies)
            saveExchangesToDB(list.map(mapper::transformToExchangeEntity))
            return@flatMap Single.create<List<Currency>> {
                it.onSuccess(currencies.map(mapper::transformFromEntity)
                    .sortedBy { currency -> currency.code })
            }
        }
    }

    @SuppressLint("CheckResult")
    private fun saveCurrenciesToDB(currencies: List<CurrencyEntity>) {
        factory.retrieveCacheDataStore().saveCurrencies(currencies).blockingGet()
    }

    @SuppressLint("CheckResult")
    private fun saveExchangesToDB(exchanges: List<ExchangeEntity>) {
        factory.retrieveCacheDataStore().saveExchanges(exchanges).blockingGet()
    }

}
