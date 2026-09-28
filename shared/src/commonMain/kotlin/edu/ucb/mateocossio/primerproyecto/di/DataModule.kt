package edu.ucb.mateocossio.primerproyecto.di

import edu.ucb.mateocossio.primerproyecto.weather.data.datasource.WeatherRemoteDataSource
import edu.ucb.mateocossio.primerproyecto.weather.data.repository.WeatherRepositoryImpl
import edu.ucb.mateocossio.primerproyecto.weather.data.service.WeatherApiService
import edu.ucb.mateocossio.primerproyecto.weather.domain.repository.WeatherRepository
import org.koin.dsl.module

val dataModule = module {
    single<WeatherRemoteDataSource> { WeatherApiService() }
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }
}
