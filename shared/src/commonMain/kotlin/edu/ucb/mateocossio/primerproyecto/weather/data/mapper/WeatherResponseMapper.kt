package edu.ucb.mateocossio.primerproyecto.weather.data.mapper

import edu.ucb.mateocossio.primerproyecto.weather.data.dto.WeatherResponseDto
import edu.ucb.mateocossio.primerproyecto.weather.domain.model.WeatherModel

fun WeatherResponseDto.toDomain(): WeatherModel {
    return WeatherModel(
        temperature = currentWeather.temperature,
        windSpeed = currentWeather.windspeed,
        windDirection = currentWeather.winddirection,
        weatherCode = currentWeather.weathercode,
        time = currentWeather.time,
        latitude = latitude,
        longitude = longitude,
    )
}
