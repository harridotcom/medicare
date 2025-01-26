package com.medicare.mentalhealth

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.medicare.R
import com.medicare.other.ui.McrNavigationBars
import com.medicare.other.ui.McrTopAppBar2
import com.medicare.other.helper.NavDestinations


@Composable
fun McrMindPage(
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
                .fillMaxSize()
                .padding(paddingValues)
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title
            item {
                Text(
                    "Mental Health Assessment",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2C3E50)
                )
            }

            // Spacer
            item {
                Spacer(modifier = Modifier.height(5.dp))
            }

            // Subtitle
            item {
                Text(
                    "Position yourself clearly in frame",
                    fontSize = 12.sp,
                    color = colorResource(R.color.information_color1)
                )
            }

            // Spacer
            item {
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Camera preview box
            item {
                Box(
                    modifier = Modifier
                        .size(400.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .border(2.dp, Color.White, RoundedCornerShape(16.dp))
                        .padding(4.dp)
                ) {
                    CameraPreview(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(12.dp))
                    )
                }
            }

            // Spacer
            item {
                Spacer(modifier = Modifier.height(4.dp))
            }

            // Profile icon
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 5.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Chat bar
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 8.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(colorResource(R.color.lighter_gray))
                                .padding(12.dp)
                        ) {
                            Text(
                                text = "Question from AI will appear here.",
                                fontSize = 10.sp,
                                color = Color.Black
                            )
                        }

                        // Orange icon
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(colorResource(R.color.orange))
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                contentDescription = "Profile",
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }

        }
    }
}