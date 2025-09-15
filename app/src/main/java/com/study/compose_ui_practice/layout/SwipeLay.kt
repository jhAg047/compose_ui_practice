package com.study.compose_ui_practice.layout

import androidx.compose.animation.core.tween
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlin.math.roundToInt

// 스와이프 제스처 감지
@Composable
fun SwipeLay(navController: NavController) {

}

@Composable
fun SwipeDemo(){
    val parentBoxWidth = 320.dp
    val childBoxSides = 30.dp

    val density = LocalDensity.current
    val decay = rememberSplineBasedDecay<Float>()

    val state = remember {
        AnchoredDraggableState(
            initialValue = "Closed",
            anchors = DraggableAnchors {
                "Closed" at 0f
                "Open" at with(density) { 200.dp.toPx() }
            },
            positionalThreshold = { it * 0.5f },
            velocityThreshold = { with(density) { 100.dp.toPx() } },
            snapAnimationSpec = tween(),
            decayAnimationSpec = decay
        )
    }

    Box(
        Modifier
            .fillMaxSize()
            .anchoredDraggable(state, Orientation.Horizontal)
    ) {
        Box(
            Modifier
                .offset { IntOffset(state.requireOffset().roundToInt(), 0) }
                .size(100.dp)
                .background(Color.Blue)
        )
    }

}