package com.medicare.physicalhealth

import android.content.Context
import android.media.AudioManager
import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.medicare.R
import com.medicare.other.ui.McrNavigationBars
import com.medicare.other.ui.McrTopAppBar2
import com.medicare.other.helper.NavDestinations

@Composable
fun McrBodyPage(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    BackHandler {
        navController.navigate(NavDestinations.HOME){
            popUpTo(NavDestinations.HOME){
                inclusive = true
            }
        }
    }

    Scaffold(
        topBar = { McrTopAppBar2() },
        bottomBar = { McrNavigationBars(navController = navController) }
    ) { paddingValues ->
        BodyPageContent(
            modifier.padding(paddingValues),
            navController = navController
        )
    }
}

@Composable
fun BodyPageContent(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Welcome Section
        item {
            Text(
                text = "Medicare AI Assistant",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 4.dp, start = 10.dp),
                fontSize = 12.sp
            )
        }

        // Video Section
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                AndroidView(
                    factory = { context ->
                        VideoView(context).apply {
                            setVideoURI(Uri.parse("android.resource://" + context.packageName + "/" + R.raw.videoplayback))
                            setMediaController(MediaController(context))
                            start()

                            // Mute the audio
                            val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
                            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, 0)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                )

            }
        }

        // Diet Section
        item {
            Sections(
                title = "Generate Diet Plan",
                description = "Get a custom diet plan tailored just for you",
                logo = painterResource(id = R.drawable.fork),
                route = NavDestinations.DIETFORM,
                navController = navController
            )
        }

        // Workout Section
        item {
            Sections(
                title = "Generate Workout Plan",
                description = "Personalized workouts tailored to your fitness journey",
                logo = painterResource(id = R.drawable._dumbel),
                route = NavDestinations.WORKOUTFORM,
                navController = navController
            )
        }
    }
}

@Composable
fun Sections(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    logo: Painter,
    route: String,
    navController: NavController
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFF5F5F5),
                shape = MaterialTheme.shapes.medium
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = logo,
                contentDescription = "$title Icon",
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 16.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color.Black
                )
                Text(
                    text = description,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }

        Button(
            onClick = { navController.navigate(route) },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.orange)
            ),
            modifier = Modifier
                .width(200.dp)
                .height(40.dp)
        ) {
            Text(
                text = "Generate Plan",
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}