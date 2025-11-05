package com.appsnicolas.huilatravel.data.model

import com.google.gson.annotations.SerializedName

data class Favorito(
    val id: Int,
    @SerializedName("usuario_id") val usuarioId: String,
    @SerializedName("lugar_id") val lugarId: String
)