package osmanowadim.currency.data.cache.entity.mapper

import osmanowadim.currency.data.cache.entity.CachedCurrencyEntity
import osmanowadim.currency.data.entity.AllCurrenciesEntity
import osmanowadim.currency.data.entity.CurrencyEntity
import javax.inject.Inject

/**
 * CachedEntityMapper class used to transformFromEntity {@link [CachedCurrencyEntity]} (in the cache layer) to {@link [CurrencyEntity]} in the
 * data layer.
 */
class CurrencyCachedEntityMapper @Inject constructor() : CachedEntityMapper<CachedCurrencyEntity, CurrencyEntity> {

    override fun mapFromCachedEntity(type: CachedCurrencyEntity) = with(type) {
        CurrencyEntity(
            id,
            name,
            code
        )
    }

    override fun mapToCachedEntity(type: CurrencyEntity) = with(type) {
        CachedCurrencyEntity(
            id,
            name,
            code
        )
    }

    fun mapToAllCurrenciesEntity(type: CachedCurrencyEntity) = with(type) {
        AllCurrenciesEntity(
            id,
            name,
            code
        )
    }

}
