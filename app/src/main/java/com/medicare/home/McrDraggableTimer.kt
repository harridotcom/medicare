package com.medicare.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.medicare.R
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

@Composable
fun DraggableTimer(onClose: () -> Unit) {  // Add onClose parameter
    var timeLeft by remember { mutableStateOf(10.minutes.inWholeSeconds) }
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }

    LaunchedEffect(Unit) {
        while (timeLeft > 0) {
            delay(1.seconds)
            timeLeft--
        }
    }

    Box(
        modifier = Modifier
            .offset { IntOffset(offsetX.toInt(), offsetY.toInt()) }
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    offsetX += dragAmount.x
                    offsetY += dragAmount.y
                }
            }
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        // Timer Text
        Text(
            text = "%02d:%02d".format(
                timeLeft / 60,
                timeLeft % 60
            ),
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier
                .shadow(4.dp, RoundedCornerShape(8.dp))
                .background(Color.White)
                .padding(16.dp)
        )

        // Close Button (Cross Icon)
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close Timer",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(24.dp)
                .clickable { onClose() },  // Call the onClose callback instead
            tint = colorResource(R.color.lighter_gray)
        )
    }
}