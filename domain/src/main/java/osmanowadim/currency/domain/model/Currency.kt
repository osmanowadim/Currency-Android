package osmanowadim.currency.domain.model

import osmanowadim.currency.domain.interactor.Params

data class Currency(
    val id: Long,
    val name: String,
    val code: String
) : Params()
