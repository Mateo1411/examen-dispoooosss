package edu.ucb.mateocossio.primerproyecto

import edu.ucb.mateocossio.primerproyecto.weather.data.dto.CurrentWeatherDto
import edu.ucb.mateocossio.primerproyecto.weather.data.dto.WeatherResponseDto
import edu.ucb.mateocossio.primerproyecto.weather.data.mapper.toDomain
import kotlin.test.Test
import kotlin.test.assertEquals

class WeatherResponseMapperTest {
    @Test
    fun convertsWeatherResponseToDomainModel() {
        val response = WeatherResponseDto(
            latitude = 40.71,
            longitude = -74.01,
            currentWeather = CurrentWeatherDto(
                temperature = 20.5,
                windspeed = 12.3,
                winddirection = 180,
                weathercode = 1,
                time = "2026-09-28T12:00",
            ),
        )

        val result = response.toDomain()

        assertEquals(20.5, result.temperature)
        assertEquals(12.3, result.windSpeed)
        assertEquals(180, result.windDirection)
        assertEquals(1, result.weatherCode)
        assertEquals("2026-09-28T12:00", result.time)
        assertEquals(40.71, result.latitude)
        assertEquals(-74.01, result.longitude)
    }
}
