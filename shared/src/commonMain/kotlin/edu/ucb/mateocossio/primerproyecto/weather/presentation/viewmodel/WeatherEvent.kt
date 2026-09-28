package edu.ucb.mateocossio.primerproyecto.weather.presentation.viewmodel

sealed interface WeatherEvent {
    data object OnRefresh : WeatherEvent
}
