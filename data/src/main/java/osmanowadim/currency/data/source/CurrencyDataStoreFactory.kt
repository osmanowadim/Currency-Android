package osmanowadim.currency.data.source

import osmanowadim.currency.data.repository.CurrencyDataStore
import javax.inject.Inject

/**
 * Create an instance of a CurrencyDataStore
 */
class CurrencyDataStoreFactory @Inject constructor(
    private val remote: CurrencyRemoteDataStore,
    private val cache: CurrencyCacheDataStore
) {

    fun retrieveCacheDataStore(): CurrencyDataStore = cache

    fun retrieveRemoteDataStore(): CurrencyDataStore = remote

}
