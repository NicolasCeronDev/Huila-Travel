
package com.appsnicolas.huilatravel.data.network

import com.appsnicolas.huilatravel.data.model.Lugar
import com.appsnicolas.huilatravel.data.model.LoginRequest
import com.appsnicolas.huilatravel.data.model.LoginResponse
import com.appsnicolas.huilatravel.data.model.RegisterRequest
import com.appsnicolas.huilatravel.data.model.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("login.php")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("registro.php")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>

    @GET("lugares.php")
    fun getLugares(): Call<List<Lugar>>
}
