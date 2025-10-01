package com.appsnicolas.huilatravel.route

data class Route(
    val id: Int,
    val title: String,
    val duration: String,
    val transport: String,
    val sites: Int,
    val description: String,
    val imageRes: Int
)