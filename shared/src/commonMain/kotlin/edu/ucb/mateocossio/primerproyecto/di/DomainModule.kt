package edu.ucb.mateocossio.primerproyecto.di

import edu.ucb.mateocossio.primerproyecto.weather.domain.usecase.GetWeatherUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    singleOf(::GetWeatherUseCase)
}
