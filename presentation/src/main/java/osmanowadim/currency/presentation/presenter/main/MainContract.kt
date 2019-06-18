package osmanowadim.currency.presentation.presenter.main

import osmanowadim.currency.presentation.InternetDependsView
import osmanowadim.currency.presentation.BasePresenter
import osmanowadim.currency.presentation.BaseView
import osmanowadim.currency.presentation.model.CurrencyPresentationModel

interface MainContract {

    interface View : BaseView<Presenter>, InternetDependsView {

        fun showCurrencies(currencies: List<CurrencyPresentationModel>)

        fun showError()

    }

    interface Presenter : BasePresenter {

        fun updateCurrencies()

    }

}
