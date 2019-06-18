package osmanowadim.currency.presentation.ui.detail

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import kotlinx.android.synthetic.main.activity_detail.*
import osmanowadim.currency.presentation.R
import osmanowadim.currency.presentation.extension.animateChangingActivitySlideLeft
import osmanowadim.currency.presentation.extension.snackbar
import osmanowadim.currency.presentation.model.CurrencyPresentationModel
import osmanowadim.currency.presentation.model.ExchangePresentationModel
import osmanowadim.currency.presentation.presenter.detail.DetailContract
import osmanowadim.currency.presentation.ui.detail.DetailActivity.Companion.CURRENCY_EXTRA_KEY
import javax.inject.Inject


fun Context.detailActivityIntent(currency: CurrencyPresentationModel) =
    Intent(this, DetailActivity::class.java).apply {
        putExtra(CURRENCY_EXTRA_KEY, currency)
    }

class DetailActivity : AppCompatActivity(), HasActivityInjector, DetailContract.View {

    override fun activityInjector(): AndroidInjector<Activity> = injector

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var detailPresenter: DetailContract.Presenter

    private lateinit var currency: CurrencyPresentationModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        detailPresenter.start()
        init()
    }

    override fun setPresenter(presenter: DetailContract.Presenter) {
        detailPresenter = presenter
    }

    override fun onDestroy() {
        super.onDestroy()
        detailPresenter.stop()
    }

    override fun showExchange(exchange: ExchangePresentationModel) {
        activity_detail_rate_tv.text = getString(R.string.exchange_rate_for, exchange.rate.toString())
        activity_detail_id_tv.text = getString(R.string.exchange_id_for, exchange.currencyId.toString())
        activity_detail_date_tv.text = getString(R.string.exchange_on, exchange.exchangeDate)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        animateChangingActivitySlideLeft()
    }

    override fun showError() {
        snackbar(activity_detail_container, R.string.exchange_error)
    }

    private fun init() {
        currency = intent.getSerializableExtra(CURRENCY_EXTRA_KEY) as CurrencyPresentationModel
        detailPresenter.currencyIsReceived(currency)
        activity_detail_toolbar.title = currency.name
    }

    companion object {

        const val CURRENCY_EXTRA_KEY = "CURRENCY_EXTRA_KEY"

    }

}
