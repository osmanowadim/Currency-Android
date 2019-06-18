package osmanowadim.currency.presentation.ui.main

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import kotlinx.android.synthetic.main.activity_main.*
import osmanowadim.currency.presentation.R
import osmanowadim.currency.presentation.extension.animateChangingActivitySlideRight
import osmanowadim.currency.presentation.extension.snackbar
import osmanowadim.currency.presentation.model.CurrencyPresentationModel
import osmanowadim.currency.presentation.presenter.main.MainContract
import osmanowadim.currency.presentation.ui.detail.detailActivityIntent
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasActivityInjector, MainContract.View {

    override fun activityInjector(): AndroidInjector<Activity> = injector

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var mainPresenter: MainContract.Presenter

    private val currencyAdapter = CurrenciesAdapter {
        startActivity(detailActivityIntent(it))
        animateChangingActivitySlideRight()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter.start()
        init()
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        mainPresenter = presenter
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.stop()
    }

    override fun isInternetAvailable(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null
    }

    override fun showNoInternetConnection() {
        snackbar(activity_main_container, R.string.internet_error)
    }

    override fun showCurrencies(currencies: List<CurrencyPresentationModel>) {
        if (currencies.isNotEmpty()) activity_main_empty_view.visibility = View.GONE
        activity_main_refresh.isRefreshing = false
        currencyAdapter.updateList(currencies)
    }

    override fun showError() {
        snackbar(activity_main_container, R.string.currency_error)
    }

    private fun init() {
        activity_main_currencies_list.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = currencyAdapter
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }
        activity_main_refresh.setOnRefreshListener {
            if (isInternetAvailable()) mainPresenter.updateCurrencies()
            else {
                showNoInternetConnection()
                activity_main_refresh.isRefreshing = false
            }
        }
    }

}
