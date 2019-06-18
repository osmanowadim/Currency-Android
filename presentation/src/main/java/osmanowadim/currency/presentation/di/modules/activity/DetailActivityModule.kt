package osmanowadim.currency.presentation.di.modules.activity

import dagger.Module
import dagger.Provides
import osmanowadim.currency.domain.interactor.exchange.GetExchangeForCurrencyUseCase
import osmanowadim.currency.domain.scopes.PerActivity
import osmanowadim.currency.presentation.mapper.CurrencyPresentationModelMapper
import osmanowadim.currency.presentation.mapper.ExchangePresentationModelMapper
import osmanowadim.currency.presentation.presenter.detail.DetailContract
import osmanowadim.currency.presentation.presenter.detail.DetailPresenter
import osmanowadim.currency.presentation.ui.detail.DetailActivity

@Module
open class DetailActivityModule {

    @PerActivity
    @Provides
    fun provideView(activity: DetailActivity) = activity as DetailContract.View

    @PerActivity
    @Provides
    fun providePresenter(
        view: DetailContract.View,
        getExchangeForCurrencyUseCase: GetExchangeForCurrencyUseCase,
        currencyPresentationModelMapper: CurrencyPresentationModelMapper,
        exchangePresentationModelMapper: ExchangePresentationModelMapper
    ): DetailContract.Presenter {
        return DetailPresenter(
            view,
            getExchangeForCurrencyUseCase,
            currencyPresentationModelMapper,
            exchangePresentationModelMapper
        )
    }

}
