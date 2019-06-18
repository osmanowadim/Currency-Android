package osmanowadim.currency.presentation.presenter.detail

import osmanowadim.currency.presentation.BasePresenter
import osmanowadim.currency.presentation.BaseView
import osmanowadim.currency.presentation.model.CurrencyPresentationModel
import osmanowadim.currency.presentation.model.ExchangePresentationModel

interface DetailContract {

    interface View : BaseView<Presenter> {

        fun showExchange(exchange: ExchangePresentationModel)

        fun showError()

    }

    interface Presenter : BasePresenter {

        fun currencyIsReceived(currency: CurrencyPresentationModel)

    }

}
