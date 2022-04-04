package com.company.tmdb.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


sealed class Screen() {
    object HomeScreen : Screen()

}

object Router {
    var currentScreen: Screen by mutableStateOf(Screen.HomeScreen)

    fun navigateTo(destination: Screen) {
        currentScreen = destination
    }
}