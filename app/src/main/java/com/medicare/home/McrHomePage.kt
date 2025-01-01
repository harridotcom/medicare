package com.medicare.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.medicare.other.McrNavigationBars
import com.medicare.other.McrTopAppBar

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun McrHomePage(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { McrTopAppBar()},
        bottomBar = {
            BottomAppBar {
                McrNavigationBars()
            }
        }
    ) { paddingValues ->
        Text(text = "HomePage", modifier = modifier.padding(paddingValues))
    }
}


