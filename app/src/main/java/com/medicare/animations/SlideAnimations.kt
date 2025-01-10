package com.medicare.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

object SlideAnimations {
    // Screen transition from right to left
    fun enterFromRight(
        duration: Int = 500,
        delay: Int = 0
    ) = slideInHorizontally(
        initialOffsetX = { fullWidth -> fullWidth },
        animationSpec = tween(
            durationMillis = duration,
            delayMillis = delay
        )
    )

    // For list items animation
    fun itemFromRight(
        index: Int,
        baseDelay: Int = 100,
        duration: Int = 500
    ) = slideInHorizontally(
        initialOffsetX = { fullWidth -> fullWidth },
        animationSpec = tween(
            durationMillis = duration,
            delayMillis = index * baseDelay
        )
    )

    // Wrapper composable for easy screen animation
    @Composable
    fun AnimatedScreen(
        content: @Composable () -> Unit
    ) {
        val isVisible = remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            isVisible.value = true
        }

        AnimatedVisibility(
            visible = isVisible.value,
            enter = enterFromRight()
        ) {
            content()
        }
    }
}