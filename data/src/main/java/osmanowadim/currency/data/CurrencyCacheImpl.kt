package osmanowadim.currency.data

import io.reactivex.Completable
import io.reactivex.Single
import osmanowadim.currency.data.cache.dao.CurrencyDao
import osmanowadim.currency.data.cache.dao.ExchangeDao
import osmanowadim.currency.data.cache.entity.mapper.CurrencyCachedEntityMapper
import osmanowadim.currency.data.cache.entity.mapper.ExchangeCachedEntityMapper
import osmanowadim.currency.data.entity.AllCurrenciesEntity
import osmanowadim.currency.data.entity.CurrencyEntity
import osmanowadim.currency.data.entity.ExchangeEntity
import osmanowadim.currency.data.repository.CurrencyCache
import javax.inject.Inject

class CurrencyCacheImpl @Inject constructor(
    private val currencyDao: CurrencyDao,
    private val exchangeDao: ExchangeDao,
    private val currencyMapper: CurrencyCachedEntityMapper,
    private val exchangeMapper: ExchangeCachedEntityMapper
) : CurrencyCache {

    override fun saveExchanges(exchanges: List<ExchangeEntity>): Completable = Completable.create {
        try {
            exchangeDao.clearAllExchanges()
            exchangeDao.insertExchanges(exchanges.map(exchangeMapper::mapToCachedEntity))
            it.onComplete()
        } catch (t: Throwable) {
            it.onError(t)
        }
    }

    override fun removeAllExchanges(): Completable = Completable.create {
        try {
            exchangeDao.clearAllExchanges()
            it.onComplete()
        } catch (t: Throwable) {
            it.onError(t)
        }
    }

    override fun getExchangeForCurrency(id: Long): Single<ExchangeEntity> {
        return exchangeDao.getExchangeForCurrency(id).flatMap { exchangeEntity ->
            Single.create<ExchangeEntity> { it.onSuccess(exchangeMapper.mapFromCachedEntity(exchangeEntity)) }
        }
    }

    override fun saveCurrencies(currencies: List<CurrencyEntity>): Completable = Completable.create {
        try {
            currencyDao.clearAllCurrencies()
            currencyDao.insertCurrencies(currencies.map(currencyMapper::mapToCachedEntity))
            it.onComplete()
        } catch (t: Throwable) {
            it.onError(t)
        }
    }

    override fun removeAllCurrencies(): Completable = Completable.create {
        try {
            currencyDao.clearAllCurrencies()
            it.onComplete()
        } catch (t: Throwable) {
            it.onError(t)
        }
    }

    override fun getAllCurrencies(): Single<List<AllCurrenciesEntity>> {
        return currencyDao.getAllCurrencies().flatMap { list ->
            Single.create<List<AllCurrenciesEntity>> { it.onSuccess(list.map(currencyMapper::mapToAllCurrenciesEntity)) }
        }
    }

}
