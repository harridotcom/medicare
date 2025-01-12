package com.medicare.home

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.medicare.other.McrNavigationBars
import com.medicare.other.McrTopAppBar
import com.medicare.other.NavDestinations


@Composable
fun McrHomePage(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val containerColor = remember { Color(0xFFF5F5F5) }
    val activity = LocalContext.current as Activity

    BackHandler {
        activity.finish()
    }

    Scaffold(
        topBar = { McrTopAppBar(navController = navController) },
        bottomBar = { McrNavigationBars(navController = navController) },
        containerColor = containerColor,
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // If you need the login button, wrap it and McrHomeContent in a proper layout
            // For example, using Box if you want to overlay them, or Column if you want them stacked
            Box(modifier = Modifier.fillMaxSize()) {
                McrHomeContent(
                    modifier = Modifier.fillMaxSize()
                        .padding(top = 20.dp)
                )

                Button(
                    onClick = { navController.navigate(NavDestinations.LOGIN) },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                ) {
                    Text(text = "Login")
                }
            }
        }
    }
}