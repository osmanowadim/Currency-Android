package osmanowadim.currency.data.entity

data class ExchangeEntity(
    var currencyId: Long = 0,
    var exchangeDate: String = "",
    var rate: Double = 0.toDouble()
)
