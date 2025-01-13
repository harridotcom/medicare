package com.medicare.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.medicare.R
import com.medicare.other.helper.NavDestinations

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun McrSignUpPage(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)), // Gray background
        contentAlignment = Alignment.TopCenter
    ) {
        // Logo at the Top
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp), // Reduced top padding
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.logo_medicare),
                contentDescription = "Medicare logo",
                modifier = Modifier
                    .height(60.dp) // Reduced logo height
                    .padding(top = 20.dp) // Reduced bottom padding
            )

            Spacer(modifier = Modifier.height(20.dp)) // Reduced space between logo and box

            Box(
                modifier = Modifier
                    .fillMaxWidth(1f) // Width of the box
                    .padding(horizontal = 12.dp) // Reduced horizontal padding
                    .background(Color.White, shape = RoundedCornerShape(16.dp))
                    .padding(16.dp) // Reduced padding inside the box
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Title
                    Text(
                        text = "Sign Up",
                        style = MaterialTheme.typography.titleMedium, // Reduced font size
                        modifier = Modifier.padding(bottom = 16.dp), // Reduced space below title
                        fontWeight = FontWeight.Bold
                    )

                    // Email Input Field
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(text = "Email") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp), // Reduced bottom padding
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_email_24),
                                contentDescription = "Email icon"
                            )
                        }
                    )

                    // Username Input Field
                    OutlinedTextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text(text = "Username") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp), // Reduced bottom padding
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_person_24),
                                contentDescription = "Username icon"
                            )
                        }
                    )

                    // Password Input Field
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text(text = "Password") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp), // Reduced bottom padding
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_lock_24),
                                contentDescription = "Password icon"
                            )
                        },
                        visualTransformation = PasswordVisualTransformation() // Hide password by default
                    )

                    // Confirm Password Input Field
                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        label = { Text(text = "Confirm Password") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp), // Reduced bottom padding
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_lock_24),
                                contentDescription = "Confirm Password icon"
                            )
                        },
                        visualTransformation = PasswordVisualTransformation() // Hide password by default
                    )

                    // Sign Up Button
                    Button(
                        onClick = { /* TODO: Add sign-up logic */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6E40)), // Pinkish-orange button
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp) // Reduced bottom padding
                            .height(48.dp) // Reduced button height
                    ) {
                        Text(
                            text = "Sign Up",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium // Reduced text size inside button
                        )
                    }

                    // Already have an account Link
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Already have an account?")
                        TextButton(onClick = {
                            navController.navigate(NavDestinations.LOGIN)
                        }) {
                            Text(text = "Login")
                        }
                    }
                }
            }
        }
    }
}
