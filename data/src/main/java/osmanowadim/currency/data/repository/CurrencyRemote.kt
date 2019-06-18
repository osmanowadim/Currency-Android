package osmanowadim.currency.data.repository

import io.reactivex.Single
import osmanowadim.currency.data.entity.AllCurrenciesEntity
import osmanowadim.currency.data.entity.CurrencyEntity
import osmanowadim.currency.data.entity.ExchangeEntity

interface CurrencyRemote {

    fun getAllCurrencies(): Single<List<AllCurrenciesEntity>>

}
