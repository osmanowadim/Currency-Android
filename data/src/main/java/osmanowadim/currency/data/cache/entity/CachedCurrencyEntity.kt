package osmanowadim.currency.data.cache.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import osmanowadim.currency.data.cache.dao.CurrencyDao

@Entity(tableName = CurrencyDao.TABLE_NAME)
data class CachedCurrencyEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val code: String
)
