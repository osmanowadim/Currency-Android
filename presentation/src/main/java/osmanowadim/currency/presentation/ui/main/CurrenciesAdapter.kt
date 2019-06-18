package osmanowadim.currency.presentation.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_currency.view.*
import osmanowadim.currency.presentation.R
import osmanowadim.currency.presentation.model.CurrencyPresentationModel

class CurrenciesAdapter(
    private val currencyClickListener: (CurrencyPresentationModel) -> Unit
) : RecyclerView.Adapter<CurrenciesAdapter.Holder>() {

    private val currenciesList = mutableListOf<CurrencyPresentationModel>()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): Holder =
        Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false))

    override fun getItemCount(): Int = currenciesList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        return holder.bind(currenciesList[position])
    }

    fun updateList(currencies: List<CurrencyPresentationModel>) {
        currenciesList.clear()
        currenciesList.addAll(currencies)
        notifyDataSetChanged()
    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(currency: CurrencyPresentationModel): Unit = with(itemView) {
            item_currency_container.setOnClickListener { currencyClickListener(currency) }
            item_currency_name_tv.text = currency.name.trim()
            item_currency_code_tv.text = currency.code.trim()
        }

    }

}
