package edu.ucb.mateocossio.primerproyecto.weather.domain.model

data class WeatherModel(
    val temperature: Double,
    val windSpeed: Double,
    val windDirection: Int,
    val weatherCode: Int,
    val time: String,
    val latitude: Double,
    val longitude: Double,
)
