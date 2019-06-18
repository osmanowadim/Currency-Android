package osmanowadim.currency.presentation.presenter.detail

import io.reactivex.observers.DisposableSingleObserver
import osmanowadim.currency.domain.interactor.Params
import osmanowadim.currency.domain.interactor.SingleUseCase
import osmanowadim.currency.domain.model.Exchange
import osmanowadim.currency.presentation.mapper.CurrencyPresentationModelMapper
import osmanowadim.currency.presentation.mapper.ExchangePresentationModelMapper
import osmanowadim.currency.presentation.model.CurrencyPresentationModel
import javax.inject.Inject

class DetailPresenter @Inject constructor(
    private val view: DetailContract.View,
    private val getExchangeForCurrencyUseCase: SingleUseCase<Exchange, Params?>,
    private val currencyMapper: CurrencyPresentationModelMapper,
    private val exchangeMapper: ExchangePresentationModelMapper
) : DetailContract.Presenter {

    override fun currencyIsReceived(currency: CurrencyPresentationModel) {
        getExchangeForCurrencyUseCase.execute(object : DisposableSingleObserver<Exchange>() {
            override fun onSuccess(t: Exchange) {
                view.showExchange(exchangeMapper.transformExchangeToPresentationModel(t))
            }

            override fun onError(e: Throwable) {
                view.showError()
            }

        }, currencyMapper.transformPresentationModelToCurrency(currency))
    }

    override fun start() {
    }

    override fun stop() {
        getExchangeForCurrencyUseCase.dispose()
    }

}
