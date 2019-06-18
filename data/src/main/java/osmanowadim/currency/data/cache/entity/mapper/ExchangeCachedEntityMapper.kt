package osmanowadim.currency.data.cache.entity.mapper

import osmanowadim.currency.data.cache.entity.CachedExchangeEntity
import osmanowadim.currency.data.entity.ExchangeEntity
import javax.inject.Inject

/**
 * CachedEntityMapper class used to transformFromEntity {@link [CachedExchangeEntity]} (in the cache layer)
 * to {@link [ExchangeEntity]} in the
 * data layer.
 */
class ExchangeCachedEntityMapper @Inject constructor() {

    fun mapFromCachedEntity(type: CachedExchangeEntity) = with(type) {
        ExchangeEntity(
            currency_id,
            exchangeDate,
            rate
        )
    }

    fun mapToCachedEntity(type: ExchangeEntity) = with(type) {
        CachedExchangeEntity(
            exchangeDate,
            rate,
            currencyId
        )
    }

}
