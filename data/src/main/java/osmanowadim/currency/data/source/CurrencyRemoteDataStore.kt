package osmanowadim.currency.data.source

import io.reactivex.Completable
import io.reactivex.Single
import osmanowadim.currency.data.entity.AllCurrenciesEntity
import osmanowadim.currency.data.entity.CurrencyEntity
import osmanowadim.currency.data.entity.ExchangeEntity
import osmanowadim.currency.data.repository.CurrencyDataStore
import osmanowadim.currency.data.repository.CurrencyRemote
import javax.inject.Inject

class CurrencyRemoteDataStore @Inject constructor(
    private val remote: CurrencyRemote
) : CurrencyDataStore {

    override fun getExchangeForCurrency(id: Long): Single<ExchangeEntity> = throw UnsupportedOperationException()

    override fun saveExchanges(exchanges: List<ExchangeEntity>): Completable = throw UnsupportedOperationException()

    override fun saveCurrencies(currencies: List<CurrencyEntity>): Completable = throw UnsupportedOperationException()

    override fun removeAllCurrencies(): Completable = throw UnsupportedOperationException()

    override fun getAllCurrencies(): Single<List<AllCurrenciesEntity>> = remote.getAllCurrencies()

}
