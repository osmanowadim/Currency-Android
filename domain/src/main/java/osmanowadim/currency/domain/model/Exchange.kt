package osmanowadim.currency.domain.model

import osmanowadim.currency.domain.interactor.Params

data class Exchange(
    val currencyId: Long,
    val exchangeDate: String,
    val rate: Double
) : Params()
