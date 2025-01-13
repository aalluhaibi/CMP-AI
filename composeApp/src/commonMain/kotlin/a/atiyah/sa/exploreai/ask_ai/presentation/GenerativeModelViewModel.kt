package a.atiyah.sa.exploreai.ask_ai.presentation

import a.atiyah.sa.exploreai.ask_ai.domain.AskAiRepository
import a.atiyah.sa.exploreai.ask_ai.domain.GenerativeModel
import a.atiyah.sa.exploreai.core.domain.onError
import a.atiyah.sa.exploreai.core.domain.onSuccess
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@Serializable
data class Entity(
    val name: String,
    val country: String
)

sealed class GenerativeModelUIState {
    data object Initial : GenerativeModelUIState()
    data object Loading : GenerativeModelUIState()
    data class Success(
        val textContent: String? = null,
        val entityContent: List<Entity>? = null,
    ) :
        GenerativeModelUIState()

    data class Error(val message: String) : GenerativeModelUIState()
}

class GenerativeModelViewModel(
    private val generativeModel: GenerativeModel,
    private val repository: AskAiRepository
) : ViewModel() {
    val uiState = MutableStateFlow<GenerativeModelUIState>(GenerativeModelUIState.Initial)
    val imageState = MutableStateFlow<String?>("")
    fun generateContent(prompt: String, generateJson: Boolean) {
        uiState.value = GenerativeModelUIState.Loading
        viewModelScope.launch {
            try {
                uiState.value = if (generateJson) {
                    val response = generativeModel.generateJsonContent(prompt)
                    if (response != null) {
                        val entities = Json.decodeFromString<List<Entity>>(response)
                        GenerativeModelUIState.Success(entityContent = entities)
                    } else {
                        GenerativeModelUIState.Error("Error generating content")
                    }
                } else {
                    val response = generativeModel.generateTextContent(prompt)
                    GenerativeModelUIState.Success(textContent = response)
                }
            } catch (e: Exception) {
                GenerativeModelUIState.Error(e.message ?: "Error generating content")
            }
        }
    }

    fun generateImage(prompt: String) {
        viewModelScope.launch {
            repository.generateImage(prompt).onSuccess { result ->
                imageState.value = result
            }.onError {
                imageState.value = null
            }
        }
    }
}