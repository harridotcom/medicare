package com.medicare.repository

import com.medicare.physicalhealth.network.McrGeminiRequest
import com.medicare.physicalhealth.network.McrGeminiResponse
import com.medicare.physicalhealth.network.McrRetrofitClientBody
import retrofit2.Call

class BodyRepository {
    private val apiService = McrRetrofitClientBody.instance
    fun getWorkoutPlan(mcrGeminiRequest: McrGeminiRequest): Call<McrGeminiResponse> {
        val response = apiService.getWorkoutPlan(mcrGeminiRequest)
        return response
    }
}