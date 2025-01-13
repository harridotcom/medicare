package com.medicare.other.helper

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.medicare.home.McrHomePage
import com.medicare.login.McrLoginPage
import com.medicare.mentalhealth.McrMindPage
import com.medicare.other.ui.IntroScreen
import com.medicare.other.ui.McrProfilePage
import com.medicare.physicalhealth.McrBodyPage
import com.medicare.physicalhealth.McrGeneratedPlan
import com.medicare.physicalhealth.McrSavedPlans
import com.medicare.physicalhealth.diet.ui.McrDietForm
import com.medicare.physicalhealth.workout.ui.McrWorkoutForm
import com.medicare.signup.McrSignUpPage
import com.medicare.womenhealth.McrCarePage
import com.medicare.womenhealth.McrReportUploadPage

@Composable
fun McrNavgation(modifier: Modifier = Modifier) {
    var navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavDestinations.INTRO_SCREEN
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
        composable(NavDestinations.PROFILE) { McrProfilePage(navController = navController) }
        composable(NavDestinations.GENERATE_PLAN) { McrGeneratedPlan(navController = navController) }
        composable(NavDestinations.SAVED_PLAN) { McrSavedPlans(navController = navController) }
        composable(NavDestinations.INTRO_SCREEN) { IntroScreen(navController = navController) }
    }
}