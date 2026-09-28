package edu.ucb.mateocossio.primerproyecto

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import edu.ucb.mateocossio.primerproyecto.weather.presentation.screen.WeatherScreen

@Composable
fun App() {
    MaterialTheme {
        WeatherScreen()
    }
}
