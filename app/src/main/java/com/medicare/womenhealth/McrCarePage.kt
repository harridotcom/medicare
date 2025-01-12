package com.medicare.womenhealth

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.medicare.other.McrNavigationBars
import com.medicare.other.McrTopAppBar2
import com.medicare.other.NavDestinations

@Composable
fun McrCarePage(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    BackHandler {
        navController.navigate(NavDestinations.HOME){
            popUpTo(NavDestinations.HOME){
                inclusive = true
            }
        }
    }

    Scaffold(
        topBar = { McrTopAppBar2() },
        bottomBar = { McrNavigationBars(navController = navController) }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(paddingValues)
        ) {
            item {
                EducationalCard()
            }

            item {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    ) {
                        // Heading Text
                        Text(
                            text = "Check Your PCOD / PCOS",
                            color = Color(0xFF333333), // Dark text color
                            style = androidx.compose.material3.MaterialTheme.typography.titleMedium, // Stylish text
                            modifier = Modifier.padding(bottom = 2.dp)
                        )
                        // Button
                        Button(
                            onClick = {
                                navController.navigate(NavDestinations.REPORT_UPLOAD)
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFFF6E40), // Vibrant orange
                                contentColor = Color.White // White text on button
                            ),
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .width(200.dp)
                                .padding(vertical = 8.dp),
                            shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp) // Rounded corners
                        ) {
                            Text(
                                text = "Test Here",
                                style = androidx.compose.material3.MaterialTheme.typography.labelLarge, // Styled button text
                                color = Color.White
                            )
                        }
                    }
                }
            }


        }
    }
}

@Composable
fun EducationalCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Light gray background box with rounded corners
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp) // Adjust height for the box
                .background(Color.LightGray.copy(alpha = 0.1f)) // Light gray color with opacity for softness
                .padding(16.dp) // Padding inside the box
                .clip(androidx.compose.foundation.shape.RoundedCornerShape(12.dp)) // Rounded corners
        ) {
            // Placeholder space for the GIF or Lottie animation
            Spacer(
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        // Text below the box
        Text(
            text = "Perform this exercise daily for better health!",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}
