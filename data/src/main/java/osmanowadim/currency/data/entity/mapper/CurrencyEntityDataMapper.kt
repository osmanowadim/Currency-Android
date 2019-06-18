package osmanowadim.currency.data.entity.mapper

import osmanowadim.currency.data.entity.AllCurrenciesEntity
import osmanowadim.currency.data.entity.CurrencyEntity
import osmanowadim.currency.data.entity.ExchangeEntity
import osmanowadim.currency.domain.interactor.Params
import osmanowadim.currency.domain.model.Currency
import osmanowadim.currency.domain.model.Exchange
import osmanowadim.currency.domain.scopes.PerApplication
import javax.inject.Inject

/**
 * Mapper class used to transformFromEntity {@link [CurrencyEntity]} (in the data layer) to {@link [Currency]} in the
 * domain layer.
 */
@PerApplication
class CurrencyEntityDataMapper @Inject constructor() {

    /**
     * Transform a {@link [CurrencyEntity]} into an {@link [Currency]} in the domain layer}
     *
     * @param currencyEntity Object to be transformed.
     * @return {@link [Currency]} if valid {@link [CurrencyEntity]}.
     */
    fun transformFromEntity(currencyEntity: CurrencyEntity) = with(currencyEntity) {
        Currency(
            id,
            name,
            code
        )
    }

    /**
     * Transform a {@link [Params]} into an {@link [CurrencyEntity]} in the data layer}
     *
     * @param params Object to be transformed.
     * @return {@link [CurrencyEntity]} if valid {@link [Currency]}.
     */
    fun transformToEntity(params: Params?): CurrencyEntity {
        return CurrencyEntity(
            (params as Currency).id,
            params.name,
            params.code
        )
    }

    fun transformToCurrencyEntity(allCurrency: AllCurrenciesEntity): CurrencyEntity {
        return CurrencyEntity(
            allCurrency.id,
            allCurrency.name,
            allCurrency.code
        )
    }

    fun transformToCurrency(allCurrency: AllCurrenciesEntity): Currency {
        return Currency(
            allCurrency.id,
            allCurrency.name,
            allCurrency.code
        )
    }

    fun transformToExchangeEntity(allCurrency: AllCurrenciesEntity): ExchangeEntity {
        return ExchangeEntity(
            allCurrency.id,
            allCurrency.exchangeDate,
            allCurrency.rate
        )
    }

    fun transformFromExchangeEntity(exchangeEntity: ExchangeEntity) = with(exchangeEntity) {
        Exchange(
            currencyId,
            exchangeDate,
            rate
        )
    }

}
