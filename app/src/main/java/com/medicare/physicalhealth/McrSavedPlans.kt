package com.medicare.physicalhealth

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.medicare.other.NavDestinations

@Composable
fun McrSavedPlans(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    BackHandler {
        navController.navigate(NavDestinations.PROFILE){
            popUpTo(NavDestinations.PROFILE){
                inclusive = true
            }
        }
    }
}