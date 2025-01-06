package com.medicare.other

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.medicare.R

@Composable
fun McrNavigationBars(modifier: Modifier = Modifier, navController: NavController) {

    val items = listOf(
        NavigationBarItem.Home,
        NavigationBarItem.PhysicalHealth,
        NavigationBarItem.WomenHealth,
        NavigationBarItem.MentalHealth
    )

    NavigationBar(
        modifier = Modifier.background(Color(0xFFF5F5F5))
    ) {
        items.forEach { item ->
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate(item.route) },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(text = item.label)}
            )
        }
    }
}

sealed class NavigationBarItem(val label: String,val icon: Int, val route: String){
    object Home: NavigationBarItem("Home", R.drawable.home, "home")
    object MentalHealth: NavigationBarItem("Mind", R.drawable.brain, "mind")
    object PhysicalHealth: NavigationBarItem("Body", R.drawable.weight, "body")
    object WomenHealth: NavigationBarItem("Women",R.drawable.women, "care")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun McrTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = { /*  */ },
        modifier = Modifier
            .background(Color(0xFFF5F5F5)),
        navigationIcon = {
            // Left Logo
            Image(
                painter = painterResource(id = R.drawable.logo_medicare),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(80.dp)
                    .padding(start = 16.dp)
            )
        },
        actions = {
            // Right Profile Icon (Circle)
            IconButton(
                onClick = { /* Handle profile click */ },
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_person_24),
                    contentDescription = "User Profile",
                    modifier = Modifier
                        .size(35.dp)
                        .border(1.dp, Color.Gray, CircleShape)
                        .padding(5.dp)
                )
            }
        }
    )
}



@Preview(showBackground = true, showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun McrTopAppBar2(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                // Company Logo
                Image(
                    painter = painterResource(id = R.drawable.logo_medicare), // Replace with your logo resource
                    contentDescription = "Company Logo",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(end = 8.dp)
                )
                // Title
                Text(
                    text = "Medicare",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFF5F5F5)),
        modifier = modifier
    )
}
