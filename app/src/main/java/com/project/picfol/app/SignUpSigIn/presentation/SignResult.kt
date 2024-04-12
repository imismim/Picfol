package com.project.picfol.app.SignUpSigIn.presentation

data class SignResult (
    val data: UserData?,
    val errorMessage: String?
)

data class UserData(
    val userId: String,
    val userName: String?,
    val profilePictureUrl: String?
)