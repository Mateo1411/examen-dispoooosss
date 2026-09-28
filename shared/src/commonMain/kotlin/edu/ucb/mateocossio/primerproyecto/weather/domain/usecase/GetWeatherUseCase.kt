package edu.ucb.mateocossio.primerproyecto.weather.domain.usecase

import edu.ucb.mateocossio.primerproyecto.weather.domain.model.WeatherModel
import edu.ucb.mateocossio.primerproyecto.weather.domain.repository.WeatherRepository

class GetWeatherUseCase(
    private val repository: WeatherRepository,
) {
    suspend fun invoke(
        latitude: Double,
        longitude: Double,
    ): Result<WeatherModel> {
        return repository.getWeather(latitude, longitude)
    }
}
