package osmanowadim.currency.presentation.presenter.main

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import osmanowadim.currency.domain.interactor.Params
import osmanowadim.currency.domain.interactor.SingleUseCase
import osmanowadim.currency.domain.model.Currency
import osmanowadim.currency.presentation.mapper.CurrencyPresentationModelMapper
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class MainPresenter @Inject constructor(
    private val view: MainContract.View,
    private val getAllCurrenciesUseCase: SingleUseCase<List<Currency>, Params?>,
    private val getAllLocalCurrencyUseCase: SingleUseCase<List<Currency>, Params?>,
    private val mapper: CurrencyPresentationModelMapper
) : MainContract.Presenter {

    private var timerCurrenciesUpdate: Disposable? = null
    private var timeInterval = 1L

    override fun start() {
        getAllCurrencies()
    }

    override fun stop() {
        getAllCurrenciesUseCase.dispose()
        getAllLocalCurrencyUseCase.dispose()
        if (timerCurrenciesUpdate != null && !timerCurrenciesUpdate!!.isDisposed) {
            timerCurrenciesUpdate!!.dispose()
        }
        timerCurrenciesUpdate = null
    }

    override fun updateCurrencies() {
        getAllCurrenciesUseCase.execute(object : DisposableSingleObserver<List<Currency>>() {
            override fun onSuccess(t: List<Currency>) {
                view.showCurrencies(t.map(mapper::transformCurrencyToPresentationModel))
                startPeriodicBackgroundUpdatesIfNeed()
            }

            override fun onError(e: Throwable) {
                view.showError()
            }

        }, null)
    }

    private fun startPeriodicBackgroundUpdatesIfNeed() {
        if (timerCurrenciesUpdate == null) {
            timerCurrenciesUpdate = Observable.interval(timeInterval, TimeUnit.MINUTES, Schedulers.io())
                .subscribe {
                    if (view.isInternetAvailable()) updateCurrencies()
                }
        }
    }

    private fun getAllCurrencies() {
        if (view.isInternetAvailable()) updateCurrencies()
        else getLocalCurrencies()
    }

    private fun getLocalCurrencies() {
        getAllLocalCurrencyUseCase.execute(object : DisposableSingleObserver<List<Currency>>() {
            override fun onSuccess(t: List<Currency>) {
                view.showCurrencies(t.map(mapper::transformCurrencyToPresentationModel))
                startPeriodicBackgroundUpdatesIfNeed()
            }

            override fun onError(e: Throwable) {
                view.showError()
            }

        }, null)
    }

}
