package com.medicare.physicalhealth.network

data class McrGeminiResponse(
    val candidates: List<Candidate>?
)

data class Candidate(
    val content: Content
)
