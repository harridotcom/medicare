package com.medicare.physicalhealth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.medicare.R
import com.medicare.other.McrNavigationBars
import com.medicare.other.McrTopAppBar2

@Composable
fun McrBodyPage(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        topBar = { McrTopAppBar2() },
        bottomBar = { McrNavigationBars(navController = navController) }
    ) { paddingValues ->
        BodyPageContent(modifier.padding(paddingValues))
    }
}

@Composable
fun BodyPageContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Diet Section
        Sections(
            title = "Generate Diet Plan",
            description = "Create a personalized diet plan to meet your health goals.",
            logo = painterResource(id = R.drawable.weight)
        )

        // Workout Section
        Sections(
            title = "Generate Workout Plan",
            description = "Design a workout plan tailored to your fitness level.",
            logo = painterResource(id = R.drawable.weight)
        )
    }
}

@Composable
fun Sections(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    logo: Painter
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = logo,
                contentDescription = "$title Icon",
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 16.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Text(
                    text = description,
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        }

        // Centered Button
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF6E40)
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .width(200.dp)
        ) {
            Text(
                text = "Generate Plan",
                color = Color.White
            )
        }
    }
}
