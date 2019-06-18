package osmanowadim.currency.data.cache.dao


import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single
import osmanowadim.currency.data.cache.entity.CachedCurrencyEntity

@Dao
interface CurrencyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrencies(cachedCurrenciesEntity: List<CachedCurrencyEntity>)

    @Query("DELETE FROM $TABLE_NAME")
    fun clearAllCurrencies()

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllCurrencies(): Single<List<CachedCurrencyEntity>>

    companion object {

        const val TABLE_NAME = "currency"

    }

}
