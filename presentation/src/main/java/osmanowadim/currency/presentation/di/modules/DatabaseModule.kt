package osmanowadim.currency.presentation.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import osmanowadim.currency.data.cache.CurrencyDB
import osmanowadim.currency.domain.scopes.PerApplication

@Module
class DatabaseModule {

    @Provides
    @PerApplication
    fun provideDatabase(context: Context) = Room
        .databaseBuilder(context, CurrencyDB::class.java, "currency.db")
        .build()

    @Provides
    @PerApplication
    fun provideCurrencyDao(db: CurrencyDB) = db.getCurrencyDao()

    @Provides
    @PerApplication
    fun provideExchangeDao(db: CurrencyDB) = db.getExchangeDao()

}
