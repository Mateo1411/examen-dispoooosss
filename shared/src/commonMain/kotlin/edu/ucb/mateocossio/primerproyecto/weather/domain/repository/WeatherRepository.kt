package edu.ucb.mateocossio.primerproyecto.weather.domain.repository

import edu.ucb.mateocossio.primerproyecto.weather.domain.model.WeatherModel

interface WeatherRepository {
    suspend fun getWeather(
        latitude: Double,
        longitude: Double,
    ): Result<WeatherModel>
}
