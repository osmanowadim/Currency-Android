package osmanowadim.currency.data.remote.services

import io.reactivex.Single
import okhttp3.ResponseBody
import osmanowadim.currency.data.entity.ExchangeEntity
import osmanowadim.currency.data.remote.entity.RemoteExchangeEntity
import retrofit2.Call
import retrofit2.http.GET

interface CurrencyService {

    @GET("exchange")
    fun getCurrencies(): Single<RemoteExchangeEntity>

}
