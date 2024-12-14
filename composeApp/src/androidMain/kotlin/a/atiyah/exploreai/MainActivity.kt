package a.atiyah.exploreai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import a.atiyah.exploreai.app.App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }
    }
}