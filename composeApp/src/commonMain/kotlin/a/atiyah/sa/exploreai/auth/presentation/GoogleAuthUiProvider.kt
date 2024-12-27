package a.atiyah.sa.exploreai.auth.presentation

import a.atiyah.sa.exploreai.auth.domain.GoogleAccount

expect class GoogleAuthUiProvider {
    suspend fun signIn(): GoogleAccount?
}