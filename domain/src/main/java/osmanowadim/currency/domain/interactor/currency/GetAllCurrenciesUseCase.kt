package osmanowadim.currency.domain.interactor.currency

import io.reactivex.Single
import osmanowadim.currency.domain.executor.PostExecutionThread
import osmanowadim.currency.domain.executor.ThreadExecutor
import osmanowadim.currency.domain.interactor.Params
import osmanowadim.currency.domain.interactor.SingleUseCase
import osmanowadim.currency.domain.model.Currency
import osmanowadim.currency.domain.repository.CurrencyRepository
import javax.inject.Inject

class GetAllCurrenciesUseCase @Inject constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val currencyRepository: CurrencyRepository
) : SingleUseCase<List<Currency>, Params?>(threadExecutor, postExecutionThread) {

    override fun buildUseCase(params: Params?): Single<List<Currency>> = currencyRepository.getAllCurrencies()

}
