package osmanowadim.currency.data.repository

import io.reactivex.Completable
import io.reactivex.Single
import osmanowadim.currency.data.entity.AllCurrenciesEntity
import osmanowadim.currency.data.entity.CurrencyEntity
import osmanowadim.currency.data.entity.ExchangeEntity

interface CurrencyDataStore {

    fun saveCurrencies(currencies: List<CurrencyEntity>): Completable

    fun saveExchanges(exchanges: List<ExchangeEntity>): Completable

    fun removeAllCurrencies(): Completable

    fun getAllCurrencies(): Single<List<AllCurrenciesEntity>>

    fun getExchangeForCurrency(id: Long): Single<ExchangeEntity>

}
