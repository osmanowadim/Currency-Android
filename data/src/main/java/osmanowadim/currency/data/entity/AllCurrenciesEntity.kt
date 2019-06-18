package osmanowadim.currency.data.entity

data class AllCurrenciesEntity (
    var id: Long = 0,
    var name: String = "",
    var code: String = "",
    var exchangeDate: String = "",
    var rate: Double = 0.toDouble()
)
