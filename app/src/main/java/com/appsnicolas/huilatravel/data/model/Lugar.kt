package com.appsnicolas.huilatravel.data.model

import com.google.gson.annotations.SerializedName

data class Lugar(
    val id: String,
    val nombre: String,
    val descripcion: String,
    @SerializedName("url_imagen") val urlImagen: String,
    val ubicacion: String,
    val calificacion: Double,
    val distancia: Int,
    val latitud: Double,
    val longitud: Double,
    val etiquetas: List<String>
)