package edu.ucb.mateocossio.primerproyecto.weather.presentation.viewmodel

import edu.ucb.mateocossio.primerproyecto.weather.domain.model.WeatherModel

data class WeatherState(
    val isLoading: Boolean = true,
    val error: String? = null,
    val weather: WeatherModel? = null,
)
