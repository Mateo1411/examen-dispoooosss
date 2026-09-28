package edu.ucb.mateocossio.primerproyecto

import androidx.compose.ui.window.ComposeUIViewController
import edu.ucb.mateocossio.primerproyecto.di.initKoinIos

@Suppress("FunctionNaming")
fun MainViewController() = run {
    initKoinIos()
    ComposeUIViewController { App() }
}
