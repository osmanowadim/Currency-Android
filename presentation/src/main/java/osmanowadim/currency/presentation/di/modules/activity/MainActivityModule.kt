package osmanowadim.currency.presentation.di.modules.activity

import dagger.Module
import dagger.Provides
import osmanowadim.currency.domain.interactor.currency.GetAllCurrenciesUseCase
import osmanowadim.currency.domain.interactor.currency.GetAllLocalCurrencyUseCase
import osmanowadim.currency.domain.scopes.PerActivity
import osmanowadim.currency.presentation.mapper.CurrencyPresentationModelMapper
import osmanowadim.currency.presentation.presenter.main.MainContract
import osmanowadim.currency.presentation.presenter.main.MainPresenter
import osmanowadim.currency.presentation.ui.main.MainActivity

@Module
open class MainActivityModule {

    @PerActivity
    @Provides
    fun provideView(activity: MainActivity) = activity as MainContract.View

    @PerActivity
    @Provides
    fun providePresenter(
        view: MainContract.View,
        getAllCurrenciesUseCase: GetAllCurrenciesUseCase,
        getAllLocalCurrencyUseCase: GetAllLocalCurrencyUseCase,
        mapper: CurrencyPresentationModelMapper
    ): MainContract.Presenter {
        return MainPresenter(view, getAllCurrenciesUseCase, getAllLocalCurrencyUseCase, mapper)
    }

}
