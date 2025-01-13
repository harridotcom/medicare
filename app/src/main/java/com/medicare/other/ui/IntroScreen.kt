package com.medicare.other.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.medicare.R
import com.medicare.other.helper.NavDestinations
import kotlinx.coroutines.delay

@Composable
fun IntroScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var startAnimation by remember { mutableStateOf(false) }
    var startExitAnimation by remember { mutableStateOf(false) }

    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation && !startExitAnimation) 1f
        else if (startExitAnimation) 0f
        else 0f,
        animationSpec = tween(
            durationMillis = 200,
            easing = if (startExitAnimation) FastOutLinearInEasing else LinearOutSlowInEasing
        ),
        finishedListener = {
            if (startExitAnimation) {
                // Navigate only after fade-out is complete
                navController.navigate(NavDestinations.HOME) {
                    popUpTo(NavDestinations.INTRO_SCREEN) {
                        inclusive = true
                    }
                }
            }
        }
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(1500L) // Show screen for 1.5 seconds
        startExitAnimation = true // Begin exit animation
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .alpha(alphaAnim.value),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.logo_medicare),
            contentDescription = "Logo",
            modifier = Modifier.size(100.dp)
        )
    }
}