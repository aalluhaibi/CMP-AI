package a.atiyah.sa.exploreai.auth.presentation

import androidx.compose.runtime.Composable

expect class GoogleAuthProvider {
    @Composable
    fun getUiProvider(): GoogleAuthUiProvider
    suspend fun signOut()
}