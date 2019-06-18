package osmanowadim.currency.data.cache.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.PrimaryKey
import osmanowadim.currency.data.cache.dao.ExchangeDao

@Entity(
    tableName = ExchangeDao.TABLE_NAME,
    foreignKeys = [ForeignKey(
        entity = CachedCurrencyEntity::class, parentColumns = ["id"],
        childColumns = ["currency_id"],
        onDelete = CASCADE
    )]
)
data class CachedExchangeEntity(
    val exchangeDate: String,
    val rate: Double,
    val currency_id: Long = 0,
    @PrimaryKey(autoGenerate = true)
    var cacheId: Long = 0
)
