package com.medicare.physicalhealth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.medicare.other.McrNavigationBars
import com.medicare.other.McrTopAppBar2

@Composable
fun McrWorkoutForm(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var fitnessGoal by remember { mutableStateOf("") }
    var workoutFrequency by remember { mutableStateOf("") }
    var availableEquipment by remember { mutableStateOf("") }

    Scaffold(
        topBar = { McrTopAppBar2() },
        bottomBar = { McrNavigationBars(navController = navController) },
        content = { paddingValues ->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Fitness Goal Input
                OutlinedTextField(
                    value = fitnessGoal,
                    onValueChange = { fitnessGoal = it },
                    label = { Text("Fitness Goal (e.g., Lose weight, Build muscle)") },
                    leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Goal") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                // Workout Frequency Input
                OutlinedTextField(
                    value = workoutFrequency,
                    onValueChange = { workoutFrequency = it },
                    label = { Text("Workout Frequency (times per week)") },
                    leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Frequency") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                // Available Equipment Input
                OutlinedTextField(
                    value = availableEquipment,
                    onValueChange = { availableEquipment = it },
                    label = { Text("Available Equipment (e.g., Dumbbells, Mat)") },
                    leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Equipment") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                // Submit Button
                Button(
                    onClick = {
                        // Handle form submission (you can process the data here)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(text = "Submit", color = Color.White)
                }
            }
        }
    )
}

