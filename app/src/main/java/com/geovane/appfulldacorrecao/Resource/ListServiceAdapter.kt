package com.geovane.appfulldacorrecao.Resource

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geovane.appfulldacorrecao.R
import com.geovane.appfulldacorrecao.model.Address
import com.geovane.appfulldacorrecao.model.Schedule
import kotlinx.android.synthetic.main.res_item_list.view.*

class ListServiceAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var listService: List<Schedule>

    // serve para a gente criar e elencar quem é o nosso ViewHolder em nossa Recycler. Infla mas não coloca na tela
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ListServiceViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.res_item_list, parent, false)
        )
    }


    // entende quem é o holder na funcao de cima, olha pra baixa sabe quantos componentes e coloca na tela.
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ListServiceViewHolder -> {
                holder.bind(listService[position])
            }
        }
    }

    // serve para dizer quantos itens que nós temos em nossa lista
    override fun getItemCount(): Int {
        return listService.size
    }

    fun setDataSet(list: List<Schedule>) {
        listService = list
    }

    class ListServiceViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind(schedule: Schedule) {

            var typeService = itemView.textViewTypeService
            var dateService = itemView.textViewDate
            var addressService = itemView.textViewAddess

            typeService.text = schedule.typeService
            dateService.text = schedule.date
            addressService.text = concatenate(schedule.address)
        }

        fun concatenate(address: Address): String {
            return "${address.logradouro}," +
                    "${address.number} - " +
                    "${address.district}, " +
                    "${address.city} - " +
                    "${address.state} / " +
                    "${address.country}"
        }
    }
}