package edu.ucb.mateocossio.primerproyecto.weather.data.repository

import edu.ucb.mateocossio.primerproyecto.weather.data.datasource.WeatherRemoteDataSource
import edu.ucb.mateocossio.primerproyecto.weather.data.mapper.toDomain
import edu.ucb.mateocossio.primerproyecto.weather.domain.model.WeatherModel
import edu.ucb.mateocossio.primerproyecto.weather.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val dataSource: WeatherRemoteDataSource,
) : WeatherRepository {
    @Suppress("TooGenericExceptionCaught")
    override suspend fun getWeather(
        latitude: Double,
        longitude: Double,
    ): Result<WeatherModel> {
        return try {
            val response = dataSource.getWeather(latitude, longitude)
            Result.success(response.toDomain())
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}
