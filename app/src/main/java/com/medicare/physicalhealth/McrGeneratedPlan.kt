package com.medicare.physicalhealth

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.medicare.animations.SlideAnimations
import com.medicare.other.McrTopAppBar2
import com.medicare.physicalhealth.diet.data.Meal
import com.medicare.physicalhealth.diet.ui.McrRecyclerViewGenerateDietPlan
import com.medicare.physicalhealth.workout.data.Exercise
import com.medicare.physicalhealth.workout.ui.McrRecyclerViewGenerateWorkoutPlan
import kotlinx.coroutines.delay

@Composable
fun McrGeneratedPlan(
    modifier: Modifier = Modifier,
//    planType: String
) {

    val exerciseList = listOf(
        Exercise("Push-up", "3 sets", "Standard push-ups to target chest and arms"),
        Exercise("Squat", "4 sets", "Squats to strengthen legs and glutes"),
        Exercise("Plank", "3 sets", "Plank to strengthen the core"),
        Exercise("Lunges", "3 sets", "Lunges to improve balance and leg strength")
    )

    SlideAnimations.AnimatedScreen {
        Scaffold(
            topBar = { McrTopAppBar2() }
        ) { paddingValues ->

            val itemVisibilities = remember {
                List(exerciseList.size) { mutableStateOf(false) }
            }

            LaunchedEffect(Unit) {
                itemVisibilities.forEachIndexed { index, state ->
                    delay(100L * index)
                    state.value = true
                }
            }

            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .padding(paddingValues)
            ) {
                itemsIndexed(exerciseList) { index, exercise ->

                    AnimatedVisibility(
                        visible = itemVisibilities[index].value,
                        enter = SlideAnimations.itemFromRight(index)
                    ) {
                        McrRecyclerViewGenerateWorkoutPlan(exercise)
                    }
                }
            }
        }
    }
}

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
