package com.medicare.womenhealth

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.medicare.R
import com.medicare.other.helper.NavDestinations
import com.medicare.other.ui.McrNavigationBars
import com.medicare.other.ui.McrTopAppBar2

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
                .padding(5.dp)
                .padding(paddingValues)
        ) {
            item {
                EducationalCard()
            }

            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(5.dp)
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

val exerciseData = listOf(
    R.drawable.height,
    R.drawable.goal,
    R.drawable.camera,
    R.drawable.baseline_email_24,
    R.drawable.baseline_lock_24
)

@Composable
fun EducationalCard(modifier: Modifier = Modifier) {
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    // Snap Fling Behavior
    val snapFlingBehavior = rememberSnapFlingBehavior(lazyListState)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyRow(
            state = lazyListState,
            flingBehavior = snapFlingBehavior,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 16.dp)
        ) {
            items(exerciseData.size) { index ->
                Image(
                    painter = painterResource(id = exerciseData[index]),
                    contentDescription = null,
                    modifier = Modifier
                        .width(350.dp)
                        .height(280.dp)
                        .clip(androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
                        .background(Color.LightGray.copy(alpha = 0.3f))
                )
            }
        }
        // Text below the box
        Text(
            text = "Perform this exercise daily for better health!",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            fontSize = 10.sp
        )
    }
}