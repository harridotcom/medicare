package com.medicare.physicalhealth.workout.ui

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
fun McrWorkoutForm(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var fitnessGoal by remember { mutableStateOf("") }
    var workoutFrequency by remember { mutableStateOf("") }
    var availableEquipment by remember { mutableStateOf("") }
    var fitnessLevel by remember { mutableStateOf("") }
    var healthConditions by remember { mutableStateOf("") }
    var workoutDuration by remember { mutableStateOf("") }

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
                    horizontalAlignment = Alignment.Start,  // Changed to Start alignment
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        Image(
                            painter = painterResource(id = R.drawable.weight),
                            contentDescription = "Dumbbell icon",
                            modifier = Modifier
                                .size(60.dp)
                                .rotate(90f)
                                .padding(start = 10.dp)  // Added start padding
                        )
                    }

                    item {
                        OutlinedTextField(
                            value = fitnessGoal,
                            onValueChange = { fitnessGoal = it },
                            label = { Text("Fitness Goal", fontSize = 12.sp) },
                            leadingIcon = {
                                Icon(
                                    Icons.Filled.Person,
                                    contentDescription = "Goal",
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
                                value = workoutFrequency,
                                onValueChange = { workoutFrequency = it },
                                label = { Text("Workout Frequency", fontSize = 12.sp) },
                                leadingIcon = {
                                    Icon(
                                        Icons.Filled.Favorite,
                                        contentDescription = "Frequency",
                                        modifier = Modifier.size(20.dp)
                                    )
                                },
                                modifier = Modifier.weight(1f),
                                singleLine = true,
                                textStyle = MaterialTheme.typography.bodyMedium
                            )

                            OutlinedTextField(
                                value = workoutDuration,
                                onValueChange = { workoutDuration = it },
                                label = { Text("Duration", fontSize = 12.sp) },
                                leadingIcon = {
                                    Icon(
                                        Icons.Filled.Home,
                                        contentDescription = "Duration",
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
                            value = availableEquipment,
                            onValueChange = { availableEquipment = it },
                            label = { Text("Available Equipment", fontSize = 12.sp) },
                            leadingIcon = {
                                Icon(
                                    Icons.Filled.Home,
                                    contentDescription = "Equipment",
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
                            value = fitnessLevel,
                            onValueChange = { fitnessLevel = it },
                            label = { Text("Fitness Level", fontSize = 12.sp) },
                            leadingIcon = {
                                Icon(
                                    Icons.Filled.Person,
                                    contentDescription = "Level",
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
                            value = healthConditions,
                            onValueChange = { healthConditions = it },
                            label = { Text("Health Conditions", fontSize = 12.sp) },
                            leadingIcon = {
                                Icon(
                                    Icons.Filled.Favorite,
                                    contentDescription = "Health",
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
                            value = healthConditions,
                            onValueChange = { healthConditions = it },
                            label = { Text("Health Conditions", fontSize = 12.sp) },
                            leadingIcon = {
                                Icon(
                                    Icons.Filled.Favorite,
                                    contentDescription = "Health",
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
                            value = healthConditions,
                            onValueChange = { healthConditions = it },
                            label = { Text("Health Conditions", fontSize = 12.sp) },
                            leadingIcon = {
                                Icon(
                                    Icons.Filled.Favorite,
                                    contentDescription = "Health",
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
                                text = "Beast Mode On",
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

