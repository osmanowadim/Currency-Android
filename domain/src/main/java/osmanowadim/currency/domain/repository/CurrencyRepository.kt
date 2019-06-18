package osmanowadim.currency.domain.repository

import io.reactivex.Single
import osmanowadim.currency.domain.interactor.Params
import osmanowadim.currency.domain.model.Currency
import osmanowadim.currency.domain.model.Exchange

/**
 * Interface that represents a Repository for getting {@link [osmanowadim.currency.domain.model.Currency]} related data.
 */
interface CurrencyRepository {

    fun getAllCurrencies(): Single<List<Currency>>

    fun getAllLocalCurrencies(): Single<List<Currency>>

    fun getExchangeForCurrency(params: Params?): Single<Exchange>

}
