package com.appsnicolas.huilatravel.data.repository

import com.appsnicolas.huilatravel.data.model.LoginRequest
import com.appsnicolas.huilatravel.data.model.RegisterRequest
import com.appsnicolas.huilatravel.data.network.RetrofitClient

class LoginRepository {

    private val apiService = RetrofitClient.instance

    suspend fun login(loginRequest: LoginRequest) = apiService.login(loginRequest)

    suspend fun register(registerRequest: RegisterRequest) = apiService.register(registerRequest)
}
