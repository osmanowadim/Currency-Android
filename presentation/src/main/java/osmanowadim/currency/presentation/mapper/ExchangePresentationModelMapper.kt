package osmanowadim.currency.presentation.mapper

import osmanowadim.currency.domain.model.Exchange
import osmanowadim.currency.presentation.model.ExchangePresentationModel
import javax.inject.Inject

/**
 * Mapper class used to :
 * transformExchangeToPresentationModel {@link [Exchange]} (in the domain layer)
 * to {@link [ExchangePresentationModel]} in the presentation layer.
 * transformPresentationModelToExchange {@link [ExchangePresentationModel]} (in the presentation layer)
 * to {@link [Exchange]} in the domain layer.
 */
class ExchangePresentationModelMapper @Inject constructor() {

    /**
     * Transform a {@link [Exchange]} into an {@link [ExchangePresentationModel]}.
     *
     * @param exchange {@link [Exchange]} Object to be transformed.
     * @return {@link [ExchangePresentationModel]} if valid {@link [Exchange]}.
     */
    fun transformExchangeToPresentationModel(exchange: Exchange) = with(exchange) {
        ExchangePresentationModel(
            this.currencyId,
            this.exchangeDate,
            this.rate
        )
    }

    /**
     * Transform a {@link [ExchangePresentationModel]} into an {@link [Exchange]}.
     *
     * @param exchangePresentationModel Object to be transformed.
     * @return {@link [Exchange]} if valid {@link [ExchangePresentationModel]}.
     */
    fun transformPresentationModelToExchange(exchangePresentationModel: ExchangePresentationModel) =
        with(exchangePresentationModel) {
            Exchange(
                this.currencyId,
                this.exchangeDate,
                this.rate
            )
        }

}
