package a.atiyah.sa.exploreai.auth.presentation

import a.atiyah.sa.exploreai.auth.presentation.component.GoogleSignInButton
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun AuthScreen(
    onNavigate: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GoogleSignInButton(onGoogleSignInResult = { googleUser ->
            println("onGoogleSignInResult: ${googleUser?.token}\n/${googleUser?.displayName}\n/${googleUser?.profileImageUrl}")
            onNavigate()
        })
    }
}