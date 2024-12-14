package a.atiyah.exploreai

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import a.atiyah.exploreai.app.App
import a.atiyah.exploreai.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "CMP-Bookpedia",
        ) {
            App()
        }
    }
}