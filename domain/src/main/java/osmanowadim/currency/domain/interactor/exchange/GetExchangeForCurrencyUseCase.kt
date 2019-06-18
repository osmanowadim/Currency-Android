package osmanowadim.currency.domain.interactor.exchange

import io.reactivex.Single
import osmanowadim.currency.domain.executor.PostExecutionThread
import osmanowadim.currency.domain.executor.ThreadExecutor
import osmanowadim.currency.domain.interactor.Params
import osmanowadim.currency.domain.interactor.SingleUseCase
import osmanowadim.currency.domain.model.Exchange
import osmanowadim.currency.domain.repository.CurrencyRepository
import javax.inject.Inject

class GetExchangeForCurrencyUseCase @Inject constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val currencyRepository: CurrencyRepository
) : SingleUseCase<Exchange, Params?>(threadExecutor, postExecutionThread) {

    override fun buildUseCase(params: Params?): Single<Exchange> = currencyRepository.getExchangeForCurrency(params)

}
