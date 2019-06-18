package osmanowadim.currency.domain.executor

import java.util.concurrent.Executor

/**
 * Executor implementation can be based on different frameworks or techniques of asynchronous
 * execution, but every implementation will execute the
 * {@link [osmanowadim.currency.domain.interactor.SingleUseCase]} out of the UI thread.
 */
interface ThreadExecutor : Executor
