package com.medicare.womenhealth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.medicare.other.McrNavigationBars
import com.medicare.other.McrTopAppBar2


@Composable
fun McrCarePage(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        topBar = { McrTopAppBar2() },
        bottomBar = { McrNavigationBars(navController = navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(paddingValues)
        ) {
            Text(text = "Care Page", modifier = modifier.padding(16.dp))
            EducationalCard()

            Spacer(modifier = Modifier.height(16.dp))

            // Check PCOD / PCOS Section
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Check your PCOD / PCOS")
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF6E40)
                        ),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                            .width(200.dp)
                    ) {
                        Text(
                            text = "Click Here",
                            color = Color.White
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun EducationalCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Perform this exercise daily for better health!",
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}
