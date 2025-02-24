package com.medicare.repository

import android.net.Uri
import android.content.Context
import com.medicare.womenhealth.network.McrCareResponse
import com.medicare.womenhealth.network.McrRetrofitClientCare
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class CareRepository(private val context: Context) {
    private val careApiService = McrRetrofitClientCare.instance

    suspend fun uploadMedicalReport(fileUri: Uri): McrCareResponse {
        return withContext(Dispatchers.IO) {
            // Convert Uri to File
            val file = uriToFile(fileUri)

            // Create MultipartBody.Part
            val requestFile = file.asRequestBody("multipart/form-data".toMediaTypeOrNull())
            val filePart = MultipartBody.Part.createFormData("file", file.name, requestFile)

            // Make API call
            careApiService.uploadFile(filePart)
        }
    }

    private fun uriToFile(uri: Uri): File {
        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
        val tempFile = File.createTempFile("upload", getFileExtension(uri))
        inputStream?.use { input ->
            FileOutputStream(tempFile).use { output ->
                input.copyTo(output)
            }
        }
        return tempFile
    }

    private fun getFileExtension(uri: Uri): String {
        val fileName = uri.path?.substringAfterLast('/')
        return if (fileName?.contains(".") == true) {
            ".${fileName.substringAfterLast('.')}"
        } else {
            ".jpg" // Default extension
        }
    }
}