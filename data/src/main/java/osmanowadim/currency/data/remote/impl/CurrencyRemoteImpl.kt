package osmanowadim.currency.data.remote.impl

import io.reactivex.Single
import osmanowadim.currency.data.entity.AllCurrenciesEntity
import osmanowadim.currency.data.remote.entity.mapper.RemoteCurrencyEntityMapper
import osmanowadim.currency.data.remote.services.CurrencyService
import osmanowadim.currency.data.repository.CurrencyRemote
import javax.inject.Inject

class CurrencyRemoteImpl @Inject constructor(
    private val currencyService: CurrencyService,
    private val mapper: RemoteCurrencyEntityMapper
) : CurrencyRemote {

    override fun getAllCurrencies(): Single<List<AllCurrenciesEntity>> {
        return currencyService.getCurrencies()
            .flatMap { exchange ->
                if (exchange.currency != null)
                    Single.create<List<AllCurrenciesEntity>> { it.onSuccess(exchange.currency!!.map(mapper::transformFromRemoteEntity)) }
                else
                    Single.create<List<AllCurrenciesEntity>> { it.onError(Throwable("Getting null when trying to download all currencies")) }
            }
    }

}
