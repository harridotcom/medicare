package com.medicare.physicalhealth

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.medicare.R
import com.medicare.other.McrNavigationBars
import com.medicare.other.McrTopAppBar2
import com.medicare.other.NavDestinations

@Composable
fun McrBodyPage(
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
        BodyPageContent(
            modifier.padding(paddingValues),
            navController = navController
        )
    }
}

@Composable
fun BodyPageContent(
    modifier: Modifier = Modifier,
    navController: NavController
) {
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
            logo = painterResource(id = R.drawable.fork),
            route = NavDestinations.DIETFORM,
            navController = navController
        )

        // Workout Section
        Sections(
            title = "Generate Workout Plan",
            description = "Design a workout plan tailored to your fitness level.",
            logo = painterResource(id = R.drawable._dumbel),
            route = NavDestinations.WORKOUTFORM,
            navController = navController
        )
    }
}

@Composable
fun Sections(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    logo: Painter,
    route: String,
    navController: NavController
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFF5F5F5),
                shape = MaterialTheme.shapes.medium
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = logo,
                contentDescription = "$title Icon",
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 16.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color.Black
                )
                Text(
                    text = description,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }

        Button(
            onClick = { navController.navigate(route) },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.orange)
            ),
            modifier = Modifier
                .width(200.dp)
                .height(40.dp)
        ) {
            Text(
                text = "Generate Plan",
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}