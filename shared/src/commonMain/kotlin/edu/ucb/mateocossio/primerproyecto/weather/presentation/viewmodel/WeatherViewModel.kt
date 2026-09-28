package edu.ucb.mateocossio.primerproyecto.weather.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucb.mateocossio.primerproyecto.weather.domain.usecase.GetWeatherUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(WeatherState())
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<WeatherEffect>()
    val effect = _effect.asSharedFlow()

    init {
        getWeather()
    }

    fun emitEvent(event: WeatherEvent) {
        when (event) {
            WeatherEvent.OnRefresh -> getWeather()
        }
    }

    private fun getWeather() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                    error = null,
                    weather = null,
                )
            }

            getWeatherUseCase.invoke(LATITUDE, LONGITUDE).fold(
                onSuccess = { weather ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            weather = weather,
                        )
                    }
                },
                onFailure = {
                    val message = "No se pudo consultar el clima"
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = message,
                        )
                    }
                    emitEffect(WeatherEffect.ShowToast(message))
                },
            )
        }
    }

    private fun emitEffect(effect: WeatherEffect) {
        viewModelScope.launch {
            _effect.emit(effect)
        }
    }

    private companion object {
        const val LATITUDE = 40.71
        const val LONGITUDE = -74.01
    }
}
