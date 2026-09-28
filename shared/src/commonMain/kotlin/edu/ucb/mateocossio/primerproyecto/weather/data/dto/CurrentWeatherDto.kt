package edu.ucb.mateocossio.primerproyecto.weather.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherDto(
    val temperature: Double,
    val windspeed: Double,
    val winddirection: Int,
    val weathercode: Int,
    val time: String,
)
