package com.project.picfol.app.SignUpSigIn.presentation.SignIn

data class SignInState(
    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)