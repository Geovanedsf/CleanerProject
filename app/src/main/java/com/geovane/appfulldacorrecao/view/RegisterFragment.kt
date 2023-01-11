package com.geovane.appfulldacorrecao.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.geovane.appfulldacorrecao.R
import com.geovane.appfulldacorrecao.model.Address
import com.geovane.appfulldacorrecao.model.Login
import com.geovane.appfulldacorrecao.model.User
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment(R.layout.fragment_register) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonRegisterAction.setOnClickListener {
            createUSer()
        }
    }

    fun createUSer() {
        val user = User(
            0,
            editTextName.text.toString(),
            editTextBirth.text.toString(),
            editTextCpf.text.toString(),
            editTextRg.text.toString(),
            Address(
                editTextAddress.text.toString(),
                editTextNumber.text.toString(),
                editTextDistrict.text.toString(),
                editTextCity.text.toString(),
                editTextState.text.toString(),
                editTextCountry.text.toString()
            ),
            Login(
                editTextEmailRegister.text.toString(),
                editTextPasswordRegister.text.toString()
            )
        )

        val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment(
            user
        )
        findNavController().navigate(action)
    }
}