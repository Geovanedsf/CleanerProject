package com.geovane.appfulldacorrecao.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.geovane.appfulldacorrecao.R
import com.geovane.appfulldacorrecao.model.Address
import com.geovane.appfulldacorrecao.model.Schedule
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_schedule.*

class ScheduleFragment : Fragment(R.layout.fragment_schedule) {

    private val args: ScheduleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTypeServiceWith(args.id)
        setButtonClicked()
    }

    fun setTypeServiceWith(id: Int) {
        when (id) {
            1 -> textViewTypeService.text = "Limpeza leve"
            2 -> textViewTypeService.text = "Limpeza moderada"
            3 -> textViewTypeService.text = "Limpeza pesada"
        }

    }

    fun setButtonClicked() {
        buttonSchedule.setOnClickListener {
            val schedule = Schedule(
                textViewTypeService.text.toString(),
                editTextAddressSchedule.text.toString(),
                Address(
                    editTextAddressSchedule.toString(),
                    editTextDistrictSchedule.toString(),
                    editTextNumberSchedule.toString(),
                    editTextCitySchedule.toString(),
                    editTextStateSchedule.toString(),
                    editTextCountrySchedule.toString()
                )
            )
            var action = ScheduleFragmentDirections.actionScheduleFragmentToSuccessFragment(
                schedule
            )
            findNavController().navigate(action)
        }
    }
}