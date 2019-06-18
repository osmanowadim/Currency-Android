package osmanowadim.currency.data.cache

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import osmanowadim.currency.data.cache.dao.CurrencyDao
import osmanowadim.currency.data.cache.dao.ExchangeDao
import osmanowadim.currency.data.cache.entity.CachedCurrencyEntity
import osmanowadim.currency.data.cache.entity.CachedExchangeEntity

@Database(entities = [CachedCurrencyEntity::class, CachedExchangeEntity::class], version = 1)
abstract class CurrencyDB : RoomDatabase() {

    abstract fun getCurrencyDao(): CurrencyDao

    abstract fun getExchangeDao(): ExchangeDao

}
