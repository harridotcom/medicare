package com.medicare.physicalhealth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.medicare.other.McrNavigationBars
import com.medicare.other.McrTopAppBar2

@Composable
fun McrDietForm(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var age by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var dietaryPreference by remember { mutableStateOf("") }

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
                // Age Input
                OutlinedTextField(
                    value = age,
                    onValueChange = { age = it },
                    label = { Text("Age") },
                    leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Age") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                // Weight Input
                OutlinedTextField(
                    value = weight,
                    onValueChange = { weight = it },
                    label = { Text("Weight (kg)") },
                    leadingIcon = { Icon(Icons.Filled.Favorite, contentDescription = "Weight") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                // Height Input
                OutlinedTextField(
                    value = height,
                    onValueChange = { height = it },
                    label = { Text("Height (cm)") },
                    leadingIcon = { Icon(Icons.Filled.Home, contentDescription = "Height") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                // Dietary Preference Input
                OutlinedTextField(
                    value = dietaryPreference,
                    onValueChange = { dietaryPreference = it },
                    label = { Text("Dietary Preference (e.g., Vegetarian, Vegan)") },
                    leadingIcon = { Icon(Icons.Filled.Home, contentDescription = "Diet Preference") },
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