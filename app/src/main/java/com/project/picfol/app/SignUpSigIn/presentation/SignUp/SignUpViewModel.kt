package com.project.picfol.app.SignUpSigIn.presentation.SignUp

import androidx.lifecycle.ViewModel
import com.project.picfol.app.SignUpSigIn.presentation.SignResult
import com.project.picfol.app.SignUpSigIn.presentation.SignState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel: ViewModel() {
    private val _state = MutableStateFlow(SignState())
    val state = _state.asStateFlow()

    fun onSignUpResult(result: SignResult){
        _state.update { it.copy(
            isSignInSuccess = result.data != null,
            signInError = result.errorMessage
        ) }
    }

    fun resetState() {
        _state.update { SignState() }
    }
}