package com.medicare.physicalhealth.diet.ui

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
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

@OptIn(ExperimentalMaterial3Api::class)
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

    // Dropdown for dietary preferences
    val dietaryOptions = listOf("Vegan", "Vegetarian", "Non-Veg", "Gluten-Free")
    var expandedDietary by remember { mutableStateOf(false) }
    var selectedDietary by remember { mutableStateOf("") }

    // Dropdown for meal preferences (weight goals)
    val mealOptions = listOf("Weight Loss", "Maintenance", "Weight Gain")
    var expandedMeal by remember { mutableStateOf(false) }
    var selectedMeal by remember { mutableStateOf("") }

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
                                    Image(
                                        painter = painterResource(id = R.drawable.age_range),
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
                                    Image(
                                        painter = painterResource(id = R.drawable.weighing_scale),
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
                                Image(
                                    painter = painterResource(id = R.drawable.height),
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

                    // Dietary Preference dropdown (Vegan, Vegetarian, Non-Veg, Gluten-Free)
                    item {
                        ExposedDropdownMenuBox(
                            expanded = expandedDietary,
                            onExpandedChange = { expandedDietary = !expandedDietary }
                        ) {
                            OutlinedTextField(
                                value = selectedDietary,
                                onValueChange = { selectedDietary = it },
                                label = { Text("Dietary Restrictions", fontSize = 12.sp) },
                                leadingIcon = {
                                    Image(
                                        painter = painterResource(id = R.drawable.height),
                                        contentDescription = "Diet Preference",
                                        modifier = Modifier.size(20.dp)
                                    )
                                },
                                modifier = Modifier
                                    .menuAnchor()
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp),
                                readOnly = true,
                                trailingIcon = {
                                    Image(
                                        painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                                        contentDescription = "DropDown",
                                        modifier = Modifier.rotate(if (expandedDietary) 180f else 0f)
                                    )
                                },
                                textStyle = MaterialTheme.typography.bodyMedium
                            )
                            ExposedDropdownMenu(
                                expanded = expandedDietary,
                                onDismissRequest = { expandedDietary = false }
                            ) {
                                dietaryOptions.forEach { option ->
                                    DropdownMenuItem(
                                        text = { Text(option) },
                                        onClick = {
                                            selectedDietary = option
                                            expandedDietary = false
                                        }
                                    )
                                }
                            }
                        }
                    }

                    item {
                        OutlinedTextField(
                            value = allergies,
                            onValueChange = { allergies = it },
                            label = { Text("Medical History", fontSize = 12.sp) },
                            leadingIcon = {
                                Image(
                                    painter = painterResource(id = R.drawable.medical_prescription),
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

                    // Meal Preference dropdown (Weight Goals: Weight Loss, Maintenance, Weight Gain)
                    item {
                        ExposedDropdownMenuBox(
                            expanded = expandedMeal,
                            onExpandedChange = { expandedMeal = !expandedMeal }
                        ) {
                            OutlinedTextField(
                                value = selectedMeal,
                                onValueChange = { selectedMeal = it },
                                label = { Text("Weight Goals", fontSize = 12.sp) },
                                leadingIcon = {
                                    Image(
                                        painter = painterResource(id = R.drawable.goal),
                                        contentDescription = "Meals",
                                        modifier = Modifier.size(20.dp)
                                    )
                                },
                                modifier = Modifier
                                    .menuAnchor()
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp),
                                readOnly = true,
                                trailingIcon = {
                                    Image(
                                        painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                                        contentDescription = "DropDown",
                                        modifier = Modifier.rotate(if (expandedMeal) 180f else 0f)
                                    )
                                },
                                textStyle = MaterialTheme.typography.bodyMedium
                            )
                            ExposedDropdownMenu(
                                expanded = expandedMeal,
                                onDismissRequest = { expandedMeal = false }
                            ) {
                                mealOptions.forEach { option ->
                                    DropdownMenuItem(
                                        text = { Text(option) },
                                        onClick = {
                                            selectedMeal = option
                                            expandedMeal = false
                                        }
                                    )
                                }
                            }
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {
                                navController.navigate(NavDestinations.GENERATE_PLAN)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.orange)
                            )
                        ) {
                            Text("Generate Plan", fontSize = 18.sp)
                        }
                    }

                }
            }
        }
    )
}
