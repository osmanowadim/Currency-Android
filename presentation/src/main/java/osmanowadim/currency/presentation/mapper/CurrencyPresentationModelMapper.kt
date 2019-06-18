package osmanowadim.currency.presentation.mapper

import osmanowadim.currency.domain.model.Currency
import osmanowadim.currency.presentation.model.CurrencyPresentationModel
import javax.inject.Inject

/**
 * Mapper class used to :
 * transformCurrencyToPresentationModel {@link [Currency]} (in the domain layer)
 * to {@link [CurrencyPresentationModel]} in the presentation layer.
 * transformPresentationModelToCurrency {@link [CurrencyPresentationModel]} (in the presentation layer)
 * to {@link [Currency]} in the domain layer.
 */
class CurrencyPresentationModelMapper @Inject constructor() {

    /**
     * Transform a {@link [Currency]} into an {@link [CurrencyPresentationModel]}.
     *
     * @param currency {@link [Currency]} Object to be transformed.
     * @return {@link [CurrencyPresentationModel]} if valid {@link [Currency]}.
     */
    fun transformCurrencyToPresentationModel(currency: Currency) = with(currency) {
        CurrencyPresentationModel(
            this.id,
            this.name,
            this.code
        )
    }

    /**
     * Transform a {@link [CurrencyPresentationModel]} into an {@link [Currency]}.
     *
     * @param currencyPresentationModel Object to be transformed.
     * @return {@link [Currency]} if valid {@link [CurrencyPresentationModel]}.
     */
    fun transformPresentationModelToCurrency(currencyPresentationModel: CurrencyPresentationModel) =
        with(currencyPresentationModel) {
            Currency(
                this.id,
                this.name,
                this.code
            )
        }

}
