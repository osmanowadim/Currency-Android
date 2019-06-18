package osmanowadim.currency.data.cache.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single
import osmanowadim.currency.data.cache.entity.CachedExchangeEntity

@Dao
interface ExchangeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExchanges(cachedCurrenciesEntity: List<CachedExchangeEntity>)

    @Query("DELETE FROM $TABLE_NAME")
    fun clearAllExchanges()

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllExchanges(): Single<List<CachedExchangeEntity>>

    @Query("SELECT * FROM $TABLE_NAME WHERE currency_id=:id")
    fun getExchangeForCurrency(id: Long): Single<CachedExchangeEntity>

    companion object {

        const val TABLE_NAME = "exchange"

    }

}
