package com.appsnicolas.huilatravel.route

import com.appsnicolas.huilatravel.R
import com.appsnicolas.huilatravel.route.Route

object SampleData {
    val routes = listOf(
        Route(
            id = 1,
            title = "Ruta Arqueológica en 1 Día",
            duration = "1 Día",
            transport = "Auto",
            sites = 3,
            description = "Descubre los secretos de la cultura agustiniana.",
            imageRes = R.drawable.route_archeo
        ),
        Route(
            id = 2,
            title = "Tour del Café Huilense",
            duration = "Medio Día",
            transport = "Caminata",
            sites = 2,
            description = "Experiencia cafetera desde grano a taza.",
            imageRes = R.drawable.route_coffee
        )
    )
}
