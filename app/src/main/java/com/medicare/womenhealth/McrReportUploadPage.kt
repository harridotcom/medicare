package com.medicare.womenhealth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.medicare.other.McrTopAppBar2

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun McrReportUploadPage(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { McrTopAppBar2() } // Custom top app bar
    ) { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .background(
                        color = Color(0xFFF9FAFB),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(24.dp)
            ) {
                // Title
                Text(
                    text = "Upload Your Report",
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2C2C2C)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Subtitle or Instruction
                Text(
                    text = "Please upload your medical report for analysis. Tap the button below to select a file.",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 16.sp,
                    color = Color(0xFF6B6B6B),
                    modifier = Modifier.padding(horizontal = 8.dp),
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(30.dp))

                // Upload Button
                IconButton(
                    onClick = { /* Handle Add Report action */ },
                    modifier = Modifier
                        .size(72.dp)
                        .background(
                            color = Color(0xFFFF7043),
                            shape = RoundedCornerShape(36.dp)
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Report",
                        tint = Color.White,
                        modifier = Modifier.size(36.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Optional Footer Text
                Text(
                    text = "Supported formats: PDF, JPG, PNG",
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 14.sp,
                    color = Color(0xFF9E9E9E)
                )
            }
        }
    }
}
