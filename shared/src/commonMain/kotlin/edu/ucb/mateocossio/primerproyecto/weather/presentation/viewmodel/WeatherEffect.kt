package edu.ucb.mateocossio.primerproyecto.weather.presentation.viewmodel

sealed interface WeatherEffect {
    data class ShowToast(val message: String) : WeatherEffect
}
