package a.atiyah.exploreai

import androidx.compose.ui.window.ComposeUIViewController
import a.atiyah.exploreai.app.App
import a.atiyah.exploreai.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }