package com.project.picfol.app.SignUpSigIn.data

import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow


interface AuthRepository {
    fun loginUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun logoutUser(email: String, password: String)

    fun registerUser(email: String, password: String): Flow<Resource<AuthResult>>
}

