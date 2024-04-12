package com.project.picfol.app.SignUpSigIn.presentation.SignUp

import androidx.lifecycle.ViewModel
import com.project.picfol.app.SignUpSigIn.presentation.SignInResult
import com.project.picfol.app.SignUpSigIn.presentation.SignInState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel: ViewModel() {
    private val _state = MutableStateFlow(SignInState())
    val state = _state.asStateFlow()

    fun onSignInResult(result: SignInResult){
        _state.update { it.copy(
            isSignInSuccess = result.data != null,
            signInError = result.errorMessage
        ) }
    }

    fun resetState() {
        _state.update { SignInState() }
    }
}