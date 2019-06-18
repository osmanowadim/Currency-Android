package osmanowadim.currency.data.remote.entity.mapper

import osmanowadim.currency.data.entity.AllCurrenciesEntity
import osmanowadim.currency.data.remote.entity.RemoteCurrencyEntity
import osmanowadim.currency.domain.scopes.PerApplication
import javax.inject.Inject


@PerApplication
class RemoteCurrencyEntityMapper @Inject constructor() {

    fun transformFromRemoteEntity(remoteCurrencyEntity: RemoteCurrencyEntity) = with(remoteCurrencyEntity) {
        AllCurrenciesEntity(
            id,
            name,
            code,
            exchangeDate,
            rate
        )
    }

}
