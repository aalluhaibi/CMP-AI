package a.atiyah.sa.exploreai.auth.presentation

import a.atiyah.sa.exploreai.auth.domain.GoogleAccount
import android.content.Context
import androidx.credentials.Credential
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException

actual class GoogleAuthUiProvider(
    private val activityContext: Context,
    private val credentialManager: CredentialManager
) {
    actual suspend fun signIn(): GoogleAccount? = try {
        val credential = credentialManager.getCredential(
            context = activityContext,
            request = getCredentialRequest()
        ).credential
        handleSignIn(credential)
    } catch (e: Exception) {
        null
    }

    private fun handleSignIn(credential: Credential): GoogleAccount? = when {
        credential is CustomCredential && credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL -> {
            try {
                val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
                GoogleAccount(
                    token = googleIdTokenCredential.idToken,
                    displayName = googleIdTokenCredential.displayName ?: "",
                    profileImageUrl = googleIdTokenCredential.profilePictureUri?.toString()
                )
            } catch (e: GoogleIdTokenParsingException) {
                null
            }
        }
        else -> null
    }

    private fun getCredentialRequest(): GetCredentialRequest = GetCredentialRequest.Builder()
        .addCredentialOption(getGoogleIdOption())
        .build()

    private fun getGoogleIdOption(): GetGoogleIdOption = GetGoogleIdOption.Builder()
        .setFilterByAuthorizedAccounts(false)
        .setAutoSelectEnabled(false)
        .setServerClientId("955907865341-01u2obnjhtdbhfccv1aupd0j05356jq8.apps.googleusercontent.com")
        .build()
}