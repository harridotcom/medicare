package com.medicare.physicalhealth

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.medicare.R
import com.medicare.animations.SlideAnimations
import com.medicare.other.ui.McrTopAppBar2
import com.medicare.other.helper.NavDestinations

@Composable
fun McrGeneratedPlan(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    BackHandler {
        navController.navigate(NavDestinations.BODY){
            popUpTo(NavDestinations.BODY){
                inclusive = true
            }
        }
    }

    SlideAnimations.AnimatedScreen {
        Scaffold(
            topBar = { McrTopAppBar2() }
        ) { paddingValues ->
            Box(modifier = Modifier.fillMaxSize()) {
                // Your main content inside the Box
                McrGeneratedPlanPdf(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(top = 16.dp) // Additional padding if needed
                )

                FloatingActionButton(
                    onClick = {
                        // Handle the button click action here
                    },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp),
                    containerColor = colorResource(R.color.orange)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Item",
                        tint = colorResource(id = R.color.white) // Use colorResource for tint
                    )
                }
            }
        }
    }
}


//    val exerciseList = listOf(
//        Exercise("Push-up", "3 sets", "Standard push-ups to target chest and arms"),
//        Exercise("Squat", "4 sets", "Squats to strengthen legs and glutes"),
//        Exercise("Plank", "3 sets", "Plank to strengthen the core"),
//        Exercise("Lunges", "3 sets", "Lunges to improve balance and leg strength")
//    )
//
//    SlideAnimations.AnimatedScreen {
//        Scaffold(
//            topBar = { McrTopAppBar2() }
//        ) { paddingValues ->
//
//            val itemVisibilities = remember {
//                List(exerciseList.size) { mutableStateOf(false) }
//            }
//
//            LaunchedEffect(Unit) {
//                itemVisibilities.forEachIndexed { index, state ->
//                    delay(100L * index)
//                    state.value = true
//                }
//            }
//
//            LazyColumn(
//                modifier = modifier
//                    .fillMaxSize()
//                    .padding(16.dp)
//                    .padding(paddingValues)
//            ) {
//                itemsIndexed(exerciseList) { index, exercise ->
//
//                    AnimatedVisibility(
//                        visible = itemVisibilities[index].value,
//                        enter = SlideAnimations.itemFromRight(index)
//                    ) {
//                        McrRecyclerViewGenerateWorkoutPlan(exercise)
//                    }
//                }
//            }
//        }
//    }


//    val mealPlanList = listOf(
//        Meal("Breakfast", "Oats, milk, banana, boiled eggs", "400"),
//        Meal("Lunch", "Chapati, butter chicken, roti, naan", "700"),
//        Meal("Dinner", "Grilled fish, steamed vegetables, brown rice", "500"),
//        Meal("Snacks", "Nuts, fruit salad, green tea", "200")
//    )
//    SlideAnimations.AnimatedScreen {
//        Scaffold(
//            topBar = { McrTopAppBar2() }
//        ) { paddingValues ->
//            val itemVisibilities = remember {
//                List(mealPlanList.size) { mutableStateOf(false) }
//            }
//
//            LaunchedEffect(Unit) {
//                itemVisibilities.forEachIndexed { index, state ->
//                    delay(100L * index)
//                    state.value = true
//                }
//            }
//
//            LazyColumn(
//                modifier = modifier
//                    .fillMaxSize()
//                    .padding(16.dp)
//                    .padding(paddingValues)
//            ) {
//                itemsIndexed(mealPlanList) { index, mealPlan ->
//                    AnimatedVisibility(
//                        visible = itemVisibilities[index].value,
//                        enter = SlideAnimations.itemFromRight(index)
//                    ) {
//                        McrRecyclerViewGenerateDietPlan(mealPlan)
//                    }
//                }
//            }
//        }
//    }
