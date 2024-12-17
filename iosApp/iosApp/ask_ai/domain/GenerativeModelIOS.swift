//
//  GenerativeModelIOS.swift
//  iosApp
//
//  Created by Abdulrahman on 15/06/1446 AH.
//  Copyright © 1446 AH orgName. All rights reserved.
//
import ComposeApp
import FirebaseCore
import FirebaseVertexAI

class GenerativeModelIOS: ComposeApp.GenerativeModel {
    static let shared = GenerativeModelIOS()

    let vertex = VertexAI.vertexAI()

    let jsonSchema = Schema.array(
      items: .object(
        properties: [
          "name": .string(),
          "country": .string()
        ]
      )
    )

    func generateTextContent(prompt: String) async throws -> String? {
        let model = vertex.generativeModel(
            modelName: "gemini-1.5-flash"
        )

        return try await model.generateContent(prompt).text
    }


    func generateJsonContent(prompt: String) async throws -> String? {
        let model = vertex.generativeModel(
            modelName: "gemini-1.5-flash",
            generationConfig: GenerationConfig(
                responseMIMEType: "application/json",
                responseSchema: jsonSchema
            )
        )

        return try await model.generateContent(prompt).text
    }
}
