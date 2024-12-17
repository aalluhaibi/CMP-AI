package a.atiyah.sa.exploreai.ask_ai.domain

import a.atiyah.sa.exploreai.di.generativeModelIOS

class GenerativeModelIOS: GenerativeModel {
    override suspend fun generateTextContent(prompt: String): String? {
        return generativeModelIOS?.generateTextContent(prompt)
    }

    override suspend fun generateJsonContent(prompt: String): String? {
        return generativeModelIOS?.generateJsonContent(prompt)
    }
}