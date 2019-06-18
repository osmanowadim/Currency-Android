package osmanowadim.currency.presentation


interface InternetDependsView {

    fun isInternetAvailable(): Boolean

    fun showNoInternetConnection()

}
