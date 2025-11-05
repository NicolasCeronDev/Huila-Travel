package com.appsnicolas.huilatravel.data.model

data class LoginResponse(
    val mensaje: String,
    val usuario: User
)

data class User(
    val id: String,
    val nombre: String,
    val correo: String
)
