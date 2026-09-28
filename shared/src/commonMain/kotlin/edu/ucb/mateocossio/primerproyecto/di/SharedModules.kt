package edu.ucb.mateocossio.primerproyecto.di

import org.koin.core.module.Module
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun sharedModule(): List<Module> = listOf(
    dataModule,
    domainModule,
    presentationModule,
)

fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        modules(sharedModule())
    }
}
