package a.atiyah.sa.exploreai.ask_ai.domain

import com.google.firebase.Firebase
import com.google.firebase.vertexai.type.Schema
import com.google.firebase.vertexai.type.generationConfig
import com.google.firebase.vertexai.vertexAI

class GenerativeModelAndroid: GenerativeModel {
    private val jsonSchema = Schema.array(
        Schema.obj(
            mapOf(
                "name" to Schema.string(),
                "country" to Schema.string()
            )
        )
    )

    override suspend fun generateTextContent(prompt: String): String? {
        val generativeModel = Firebase.vertexAI.generativeModel(
            modelName = "gemini-1.5-flash"
        )

        return generativeModel.generateContent(prompt).text
    }

    override suspend fun generateJsonContent(prompt: String): String? {
        val generativeModel = Firebase.vertexAI.generativeModel(
            modelName = "gemini-1.5-flash",
            generationConfig = generationConfig {
                responseMimeType = "application/json"
                responseSchema = jsonSchema
            }
        )

        return generativeModel.generateContent(prompt).text
    }
}