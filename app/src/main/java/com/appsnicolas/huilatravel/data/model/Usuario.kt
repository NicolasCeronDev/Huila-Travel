package com.appsnicolas.huilatravel.data.model

import com.google.gson.annotations.SerializedName

data class Usuario(
    val id: String,
    val correo: String,
    val nombre: String,
    @SerializedName("fecha_creacion") val fechaCreacion: String
)