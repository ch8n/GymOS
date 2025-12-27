package dev.ch8n.gymos

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "GymOS",
    ) {
        App()
    }
}