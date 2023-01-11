package com.geovane.appfulldacorrecao.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.geovane.appfulldacorrecao.R
import com.geovane.appfulldacorrecao.model.Schedule
import kotlinx.android.synthetic.main.fragment_success.*

class SuccessFragment : Fragment(R.layout.fragment_success) {

    private val args: SuccessFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDescSchedule()
    }

    fun setDescSchedule(){
        textViewDescSuccess.text = concatenate(args.schedule)
    }

    fun concatenate(schedule: Schedule) : String {
        return "" +
                "${schedule.typeService}: " +
                "${schedule.date} - Endereço: " +
                "${schedule.address.logradouro}, " +
                "${schedule.address.number} - " +
                "${schedule.address.district}, " +
                "${schedule.address.city} - " +
                "${schedule.address.state} / " +
                "${schedule.address.country}"
    }
}