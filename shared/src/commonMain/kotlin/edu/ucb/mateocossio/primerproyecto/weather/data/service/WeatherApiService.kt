package edu.ucb.mateocossio.primerproyecto.weather.data.service

import edu.ucb.mateocossio.primerproyecto.weather.data.datasource.WeatherRemoteDataSource
import edu.ucb.mateocossio.primerproyecto.weather.data.dto.WeatherResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class WeatherApiService : WeatherRemoteDataSource {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                },
            )
        }
    }

    override suspend fun getWeather(
        latitude: Double,
        longitude: Double,
    ): WeatherResponseDto {
        return client.get(BASE_URL) {
            parameter("latitude", latitude)
            parameter("longitude", longitude)
            parameter("current_weather", true)
        }.body()
    }

    private companion object {
        const val BASE_URL = "https://api.open-meteo.com/v1/forecast"
    }
}
