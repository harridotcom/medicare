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
                .size(450.dp)
                .padding(16.dp)
                .padding(paddingValues)
                .padding(top = 30.dp)
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(16.dp)
                )
                .background(
                    color = Color(0xFFF5F5F5),
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Upload your Report",
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF333333)
                )
                Spacer(modifier = Modifier.height(25.dp))
                IconButton(
                    onClick = { /* Handle Add Report action */ },
                    modifier = Modifier
                        .size(64.dp)
                        .padding(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Report",
                        modifier = Modifier.size(48.dp),
                        tint = Color(0xFFFF6E40)
                    )
                }
            }
        }
    }
}
