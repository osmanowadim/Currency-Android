package osmanowadim.currency.data.source

import io.reactivex.Completable
import io.reactivex.Single
import osmanowadim.currency.data.entity.AllCurrenciesEntity
import osmanowadim.currency.data.entity.CurrencyEntity
import osmanowadim.currency.data.entity.ExchangeEntity
import osmanowadim.currency.data.repository.CurrencyCache
import osmanowadim.currency.data.repository.CurrencyDataStore
import javax.inject.Inject

class CurrencyCacheDataStore @Inject constructor(
    private val cache: CurrencyCache
) : CurrencyDataStore {

    override fun getExchangeForCurrency(id: Long): Single<ExchangeEntity> = cache.getExchangeForCurrency(id)

    override fun saveExchanges(exchanges: List<ExchangeEntity>): Completable = cache.saveExchanges(exchanges)

    override fun saveCurrencies(currencies: List<CurrencyEntity>): Completable = cache.saveCurrencies(currencies)

    override fun removeAllCurrencies(): Completable = cache.removeAllCurrencies()

    override fun getAllCurrencies(): Single<List<AllCurrenciesEntity>> = cache.getAllCurrencies()

}
