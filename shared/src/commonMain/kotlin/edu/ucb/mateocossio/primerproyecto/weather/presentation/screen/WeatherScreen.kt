package edu.ucb.mateocossio.primerproyecto.weather.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.ucb.mateocossio.primerproyecto.weather.presentation.viewmodel.WeatherEvent
import edu.ucb.mateocossio.primerproyecto.weather.presentation.viewmodel.WeatherViewModel
import org.koin.compose.viewmodel.koinViewModel
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = koinViewModel()
) {
    val state = viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Clima actual")

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                viewModel.emitEvent(WeatherEvent.OnRefresh)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        ) {
            Text("Actualizar")
        }

        Spacer(modifier = Modifier.height(15.dp))

        if (state.value.isLoading) {
            Text("Cargando...")
        }

        state.value.error?.let { error ->
            Text(error)
        }

        state.value.weather?.let { weather ->
            Text("Temperatura: ${weather.temperature} °C")
            Text("Velocidad del viento: ${weather.windSpeed} km/h")
            Text("Dirección del viento: ${weather.windDirection}°")
            Text("Código del clima: ${weather.weatherCode}")
            Text("Fecha y hora: ${weather.time}")
            Text("Latitud: ${weather.latitude}")
            Text("Longitud: ${weather.longitude}")
        }
    }
}