package edu.ucb.mateocossio.primerproyecto

import android.app.Application
import edu.ucb.mateocossio.primerproyecto.di.initKoinAndroid

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoinAndroid(this)
    }
}
