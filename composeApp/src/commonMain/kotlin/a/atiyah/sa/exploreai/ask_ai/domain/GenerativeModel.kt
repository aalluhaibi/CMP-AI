package a.atiyah.sa.exploreai.ask_ai.domain

interface GenerativeModel {
    suspend fun generateTextContent(prompt: String): String?
    suspend fun generateJsonContent(prompt: String): String?
}