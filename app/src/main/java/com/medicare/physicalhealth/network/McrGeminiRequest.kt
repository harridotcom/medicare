package com.medicare.physicalhealth.network

data class McrGeminiRequest(
    val contents: List<Content>
)

data class Content(
    val parts: List<Part>
)

data class Part(
    val text: String
)
