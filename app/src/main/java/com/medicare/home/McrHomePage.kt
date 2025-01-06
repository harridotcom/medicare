package com.medicare.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.medicare.other.McrNavigationBars
import com.medicare.other.McrTopAppBar

@Composable
fun McrHomePage(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        topBar = { McrTopAppBar()},
        bottomBar = {
            BottomAppBar {
                McrNavigationBars(navController = navController)
            }
        },
        containerColor = Color(0xFFF5F5F5),
    ) { paddingValues ->
        Text(text = "HomePage", modifier = modifier.padding(paddingValues))
    }
}


