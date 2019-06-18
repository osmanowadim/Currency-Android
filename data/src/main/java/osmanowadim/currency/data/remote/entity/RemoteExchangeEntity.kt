package osmanowadim.currency.data.remote.entity

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "exchange", strict = false)
data class RemoteExchangeEntity(
    @field:ElementList(name = "currency", inline = true)
    var currency: List<RemoteCurrencyEntity>? = null
)
