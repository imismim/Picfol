package com.project.picfol.app.Profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.project.picfol.R
import com.project.picfol.ui.theme.UltraViolet

@Composable
fun ProfileScreen() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.moon10))

    var isPlay by remember {
        mutableStateOf(true)
    }

    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isPlay
    )
    LaunchedEffect(key1 = progress) {
        if (progress == 0f) {
            isPlay = true
        } else if (progress == 1f) {
            isPlay = false
        }
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(UltraViolet),
        color = UltraViolet,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LottieAnimation(
                composition = composition,
                progress = { progress },
                modifier = Modifier
                    .clip(CircleShape)
                    .size(100.dp)
                    .clickable {
                        isPlay = true
                    }
            )
        }
    }

}

@Preview
@Composable
fun Fun() {
    ProfileScreen()

}