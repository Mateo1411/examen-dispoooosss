package edu.ucb.mateocossio.primerproyecto.di

import edu.ucb.mateocossio.primerproyecto.weather.presentation.viewmodel.WeatherViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::WeatherViewModel)
}
