package com.geovane.appfulldacorrecao.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.geovane.appfulldacorrecao.model.User
import com.geovane.appfulldacorrecao.view.LoginFragment
import kotlinx.android.synthetic.main.fragment_login.*

class LoginViewModel(val fragment: LoginFragment): ViewModel() {

    fun validadeLogin(user: User, callback: (result: (Boolean)) -> Unit) {
        if (user.login.email != fragment.textEmailLogin.text.toString() ||
                user.login.senha != fragment.textPasswordLogin.text.toString()) {
            callback.invoke(false)
        } else {
            callback.invoke(true)
        }
    }

    class LoginViewModelProvider(
        val fragment: LoginFragment
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginViewModel(fragment) as T
        }
    }
}