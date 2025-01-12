package com.medicare.physicalhealth.diet.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.medicare.R
import com.medicare.other.McrNavigationBars
import com.medicare.other.McrTopAppBar2
import com.medicare.other.NavDestinations

@Composable
fun McrDietForm(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var age by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var dietaryPreference by remember { mutableStateOf("") }
    var allergies by remember { mutableStateOf("") }
    var healthGoals by remember { mutableStateOf("") }
    var mealPreference by remember { mutableStateOf("") }

    BackHandler {
        navController.navigate(NavDestinations.BODY){
            popUpTo(NavDestinations.BODY){
                inclusive = true
            }
        }
    }


    Scaffold(
        topBar = { McrTopAppBar2() },
        bottomBar = { McrNavigationBars(navController = navController) },
        content = { paddingValues ->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        Image(
                            painter = painterResource(id = R.drawable.healthy_food),
                            contentDescription = "Dumbbell icon",
                            modifier = Modifier
                                .size(80.dp)
                                .padding(start = 10.dp)
                        )
                    }

                    item {
                        OutlinedTextField(
                            value = healthGoals,
                            onValueChange = { healthGoals = it },
                            label = { Text("Health Goals", fontSize = 12.sp) },
                            leadingIcon = {
                                Icon(
                                    Icons.Filled.Favorite,
                                    contentDescription = "Goals",
                                    modifier = Modifier.size(20.dp)
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            singleLine = true,
                            textStyle = MaterialTheme.typography.bodyMedium
                        )
                    }

                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            OutlinedTextField(
                                value = age,
                                onValueChange = { age = it },
                                label = { Text("Age", fontSize = 12.sp) },
                                leadingIcon = {
                                    Icon(
                                        Icons.Filled.Person,
                                        contentDescription = "Age",
                                        modifier = Modifier.size(20.dp)
                                    )
                                },
                                modifier = Modifier.weight(1f),
                                singleLine = true,
                                textStyle = MaterialTheme.typography.bodyMedium
                            )

                            OutlinedTextField(
                                value = weight,
                                onValueChange = { weight = it },
                                label = { Text("Weight (kg)", fontSize = 12.sp) },
                                leadingIcon = {
                                    Icon(
                                        Icons.Filled.Favorite,
                                        contentDescription = "Weight",
                                        modifier = Modifier.size(20.dp)
                                    )
                                },
                                modifier = Modifier.weight(1f),
                                singleLine = true,
                                textStyle = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }

                    item {
                        OutlinedTextField(
                            value = height,
                            onValueChange = { height = it },
                            label = { Text("Height (cm)", fontSize = 12.sp) },
                            leadingIcon = {
                                Icon(
                                    Icons.Filled.Home,
                                    contentDescription = "Height",
                                    modifier = Modifier.size(20.dp)
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            singleLine = true,
                            textStyle = MaterialTheme.typography.bodyMedium
                        )
                    }

                    item {
                        OutlinedTextField(
                            value = dietaryPreference,
                            onValueChange = { dietaryPreference = it },
                            label = { Text("Dietary Preference", fontSize = 12.sp) },
                            leadingIcon = {
                                Icon(
                                    Icons.Filled.Home,
                                    contentDescription = "Diet Preference",
                                    modifier = Modifier.size(20.dp)
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            singleLine = true,
                            textStyle = MaterialTheme.typography.bodyMedium
                        )
                    }

                    item {
                        OutlinedTextField(
                            value = allergies,
                            onValueChange = { allergies = it },
                            label = { Text("Food Allergies", fontSize = 12.sp) },
                            leadingIcon = {
                                Icon(
                                    Icons.Filled.Person,
                                    contentDescription = "Allergies",
                                    modifier = Modifier.size(20.dp)
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            singleLine = true,
                            textStyle = MaterialTheme.typography.bodyMedium
                        )
                    }

                    item {
                        OutlinedTextField(
                            value = mealPreference,
                            onValueChange = { mealPreference = it },
                            label = { Text("Meal Preferences", fontSize = 12.sp) },
                            leadingIcon = {
                                Icon(
                                    Icons.Filled.Home,
                                    contentDescription = "Meals",
                                    modifier = Modifier.size(20.dp)
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            singleLine = true,
                            textStyle = MaterialTheme.typography.bodyMedium
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {
                                navController.navigate(NavDestinations.GENERATE_PLAN)
                            },
                            modifier = Modifier
                                .width(200.dp)
                                .padding(bottom = 16.dp)
                                .align(Alignment.CenterHorizontally),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.orange)
                            )
                        ) {
                            Text(
                                text = "Let's Eat Smart",
                                color = colorResource(id = R.color.white),
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
    )
}