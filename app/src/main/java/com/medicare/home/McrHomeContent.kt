package com.medicare.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.medicare.R
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun McrHomeContent(
    modifier: Modifier = Modifier,
) {
    val backgroundColor = Color.White
    var showTimer by remember { mutableStateOf(false) }  // Add this line

    Box(modifier = Modifier.fillMaxSize()) {  // Add this Box
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Meditation Card
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(horizontal = 2.dp),
                    colors = CardDefaults.cardColors(containerColor = backgroundColor),
                    shape = RoundedCornerShape(10.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.brain),
                            contentDescription = "Brain icon",
                            tint = Color.Green,
                            modifier = Modifier.size(32.dp)
                        )
                        Text(
                            text = "Daily Meditation",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.SemiBold
                            ),
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp
                        )
                        Text(
                            text = "10 minutes for inner peace",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center,
                            fontSize = 10.sp,
                            color = colorResource(R.color.information_color1)
                        )

                        Button(
                            onClick = { showTimer = true },  // Modify this line
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.orange)
                            ),
                            modifier = Modifier.padding(top = 8.dp),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "Begin Journey",
                                modifier = Modifier.padding(horizontal = 32.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
            }
        }

        if (showTimer) {
            DraggableTimer(onClose = { showTimer = false })  // Pass the callback
        }
    }
}

