package com.mabrouk.mohamed.cardscanner.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun AnimatedImage(
    modifier: Modifier = Modifier,
    animationResource: Int,
    iterations: Int,
    isPlaying: Boolean,
    onAnimationFinished: () -> Unit,
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(animationResource)
    )

    val progress by animateLottieCompositionAsState(
        composition,
        iterations = iterations,
        isPlaying = isPlaying
    )

    LottieAnimation(
        composition = composition,
        progress = progress,
        modifier = modifier
    )

    if (progress == 1f && iterations == 1) {
        onAnimationFinished.invoke()
    }
}