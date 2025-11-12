package com.appsnicolas.huilatravel.ui.rutasItenerario

object SampleItinerary {
    val steps = listOf(
        ItineraryStep(
            id = 1,
            number = 1,
            title = "Mañana: Visita al Parque Arqueológico de San Agutín",
            subtitle = "",
            timeRange = "9:00 AM - 12:00 PM"
        ),
        ItineraryStep(
            id = 2,
            number = 2,
            title = "Almuerzo: Restaurante en San Agutín",
            subtitle = "",
            timeRange = "12:30 PM - 1:30 PM"
        ),
        ItineraryStep(
            id = 3,
            number = 3,
            title = "Tarde: Museo Arqueológico y Tablón",
            subtitle = "",
            timeRange = "2:00 PM - 4:30 PM"
        )
    )
}