package com.medicare.womenhealth

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.medicare.R
import com.medicare.animations.SlideAnimations
import com.medicare.other.ui.McrTopAppBar2

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun McrReportUploadPage(
    modifier: Modifier = Modifier,
    onUploadComplete: (Uri?) -> Unit = {}
) {
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var selectedFileUri by remember { mutableStateOf<Uri?>(null) }
    var uploadStatus by remember { mutableStateOf<String?>(null) }

    // Camera launcher
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { success ->
        if (success) {
            selectedFileUri = null
            uploadStatus = "Photo captured successfully"
        }
    }

    // File picker launcher
    val fileLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            selectedImageUri = null
            selectedFileUri = it
            uploadStatus = "File selected successfully"
        }
    }
    SlideAnimations.AnimatedScreen {
        Scaffold(
            topBar = { McrTopAppBar2() }
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
                        .shadow(elevation = 2.dp, shape = RoundedCornerShape(10.dp))
                        .background(color = colorResource(R.color.white), shape = RoundedCornerShape(10.dp))
                        .padding(24.dp)
                ) {
                    Text(
                        text = "Upload Medical Report",
                        style = MaterialTheme.typography.headlineSmall,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.black)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Choose how you'd like to upload your medical report:",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 14.sp,
                        color = colorResource(R.color.information_color2),
                        modifier = Modifier.padding(horizontal = 8.dp),
                        textAlign = TextAlign.Center,
                        lineHeight = 20.sp
                    )

                    Spacer(modifier = Modifier.height(26.dp))

                    // Upload options
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Camera Button
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.weight(1f)
                        ) {
                            ElevatedButton(
                                onClick = { selectedImageUri?.let { cameraLauncher.launch(it) } },
                                colors = ButtonDefaults.elevatedButtonColors(
                                    containerColor = colorResource(R.color.lighter_gray),
                                    contentColor = Color.Black  // Changed to black
                                ),
                                modifier = Modifier.size(80.dp),
                                shape = RectangleShape,
                                elevation = ButtonDefaults.elevatedButtonElevation(
                                    defaultElevation = 6.dp,
                                    pressedElevation = 8.dp
                                )
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.camera),
                                    contentDescription = "Camera",
                                    modifier = Modifier.size(32.dp),
                                    tint = Color.Unspecified
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                "Camera",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                color = colorResource(R.color.black)
                            )
                        }

                        // File Upload Button
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.weight(1f)
                        ) {
                            ElevatedButton(
                                onClick = { fileLauncher.launch("*/*") },
                                colors = ButtonDefaults.elevatedButtonColors(
                                    containerColor = colorResource(R.color.lighter_gray),
                                    contentColor = Color.Black  // Changed to black
                                ),
                                modifier = Modifier.size(80.dp),
                                shape = RectangleShape,
                                elevation = ButtonDefaults.elevatedButtonElevation(
                                    defaultElevation = 6.dp,
                                    pressedElevation = 8.dp
                                )
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.upload),
                                    contentDescription = "Upload",
                                    modifier = Modifier.size(32.dp),
                                    tint = Color.Unspecified
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                "Upload",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                color = colorResource(R.color.black)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Preview Section
                    if (selectedImageUri != null || selectedFileUri != null) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .background(Color.LightGray, RoundedCornerShape(8.dp))
                        ) {
                            when {
                                selectedImageUri != null -> {
                                    AsyncImage(
                                        model = selectedImageUri,
                                        contentDescription = "Selected Image",
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }
                                selectedFileUri != null -> {
                                    // Show file name or icon for PDFs
                                    Text(
                                        text = "Selected File: ${selectedFileUri.toString().substringAfterLast("/")}",
                                        modifier = Modifier
                                            .align(Alignment.Center)
                                            .padding(16.dp)
                                    )
                                }
                            }

                            // Clear selection button
                            IconButton(
                                onClick = {
                                    selectedImageUri = null
                                    selectedFileUri = null
                                    uploadStatus = null
                                },
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .padding(8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Clear Selection",
                                    tint = Color.White
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Upload status
                    uploadStatus?.let {
                        Text(
                            text = it,
                            color = colorResource(R.color.green),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Upload Button
                    Button(
                        onClick = {
                            // Handle final upload
                            selectedImageUri?.let { onUploadComplete(it) }
                            selectedFileUri?.let { onUploadComplete(it) }
                        },
                        enabled = selectedImageUri != null || selectedFileUri != null,
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.orange),
                            disabledContainerColor = Color.Gray
                        )
                    ) {
                        Text("Upload Report", color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // File requirements
                    Text(
                        text = "Supported formats: PDF, JPG, PNG\nMaximum file size: 10MB",
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 12.sp,
                        color = colorResource(R.color.information_color1),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}