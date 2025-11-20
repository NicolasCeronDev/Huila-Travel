package com.appsnicolas.huilatravel.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Usuario(
    val id: String,
    val correo: String,
    val nombre: String,
    @SerializedName("fecha_creacion") val fechaCreacion: String
) : Parcelable