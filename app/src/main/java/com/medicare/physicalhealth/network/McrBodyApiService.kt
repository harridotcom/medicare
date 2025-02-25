import com.medicare.physicalhealth.network.McrGeminiRequest
import com.medicare.physicalhealth.network.McrGeminiResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface McrBodyApiService {
    @Headers("Content-Type: application/json")
    @POST("v1beta/models/gemini-2.0-flash:generateContent")
    fun getWorkoutPlan(@Body request: McrGeminiRequest): Call<McrGeminiResponse>
}
