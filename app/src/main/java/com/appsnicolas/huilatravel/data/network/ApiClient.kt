package com.appsnicolas.huilatravel.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    // Esta es la IP de tu computadora en la red Wi-Fi.
    // Asegúrate de que tu teléfono físico esté en la misma red Wi-Fi.
    // Si usas el emulador de Android, puedes cambiar esta IP por "http://10.0.2.2/huila_travel/"
    private const val BASE_URL = "http://192.168.20.15/huila_travel/"

    val apiService: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }
}
