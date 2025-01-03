package com.medicare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.medicare.home.McrHomePage
import com.medicare.ui.theme.MediCareTheme
import com.medicare.womenhealth.McrCarePage
import com.medicare.womenhealth.McrReportUploadPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MediCareTheme {
                McrReportUploadPage()
            }
        }
    }
}

