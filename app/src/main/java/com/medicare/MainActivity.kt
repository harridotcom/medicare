package com.medicare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.medicare.other.McrNavgation
import com.medicare.ui.theme.MediCareTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MediCareTheme {
//                McrReportUploadPage()
//                McrLoginPage()
//                McrSignUpPage()c
//                McrHomePage()
                McrNavgation()
//                McrLoginPage()
//                McrSavedPlans()

            }
        }
    }
}