package com.medicare.womenhealth.network

import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface McrCareService {
    @Multipart
    @POST("predict")
    suspend fun uploadFile(
        @Part file: MultipartBody.Part
    ): McrCareResponse
}