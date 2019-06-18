package osmanowadim.currency.data.cache.entity.mapper

interface CachedEntityMapper<E, T> {

    fun mapFromCachedEntity(type: E): T

    fun mapToCachedEntity(type: T): E

}
