package edu.ucb.mateocossio.primerproyecto.weather.data.datasource

import edu.ucb.mateocossio.primerproyecto.weather.data.dto.WeatherResponseDto

interface WeatherRemoteDataSource {
    suspend fun getWeather(
        latitude: Double,
        longitude: Double,
    ): WeatherResponseDto
}
