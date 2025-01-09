package com.medicare.other

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.medicare.home.McrHomePage
import com.medicare.login.McrLoginPage
import com.medicare.mentalhealth.McrMindPage
import com.medicare.physicalhealth.McrBodyPage
import com.medicare.physicalhealth.McrDietForm
import com.medicare.physicalhealth.McrWorkoutForm
import com.medicare.signup.McrSignUpPage
import com.medicare.womenhealth.McrCarePage
import com.medicare.womenhealth.McrReportUploadPage

@Composable
fun McrNavgation(modifier: Modifier = Modifier) {
    var navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavDestinations.HOME
    ) {
        composable(NavDestinations.LOGIN) { McrLoginPage(navController = navController) }
        composable(NavDestinations.SIGNUP) { McrSignUpPage(navController = navController) }
        composable(NavDestinations.HOME) { McrHomePage(navController = navController) }
        composable(NavDestinations.MIND) { McrMindPage(navController = navController) }
        composable(NavDestinations.BODY) { McrBodyPage(navController = navController) }
        composable(NavDestinations.CARE) { McrCarePage(navController = navController) }
        composable(NavDestinations.REPORT_UPLOAD) { McrReportUploadPage() }
        composable(NavDestinations.DIETFORM) { McrDietForm(navController = navController) }
        composable(NavDestinations.WORKOUTFORM) { McrWorkoutForm(navController = navController) }
    }
}