package com.medicare.mentalhealth

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.medicare.other.McrNavigationBars
import com.medicare.other.McrTopAppBar2

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun McrMindPage(modifier: Modifier = Modifier) {
    Scaffold (
        topBar = { McrTopAppBar2() },
        bottomBar = { McrNavigationBars() }
    ){paddingValues ->
        Text(text = "Mind Page", modifier = modifier.padding(paddingValues))
    }
}