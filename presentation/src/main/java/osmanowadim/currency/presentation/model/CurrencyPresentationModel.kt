package osmanowadim.currency.presentation.model

import java.io.Serializable

data class CurrencyPresentationModel(
    val id: Long,
    val name: String,
    val code: String
) : Serializable
