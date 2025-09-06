package com.study.compose_ui_practice.layout

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// 시각적 애니메이션
@Composable
fun AnimateLay(navController: NavController) {

    var boxVisible by remember { mutableStateOf(true) }


    // 애니메이션 자동 시작
    val state = remember {MutableTransitionState(false)}
    state.apply { targetState = true }


    val onClick = { newState : Boolean ->
        boxVisible = newState
    }

    Column(
        Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // 교차 페이딩 - 박스 상태에 따른 버튼 표시 유무 설정
            Crossfade(
                targetState = boxVisible,
                animationSpec = tween(5000)
            ) { visible ->
                when(visible) {
                    true -> CustomButton(text = "Hide", targetState = false, onClick = onClick, bgColor = Color.Red)
                    false -> CustomButton(text = "Show", targetState = true, onClick = onClick, bgColor = Color.Magenta)
                }

            }

//            CustomButton(text = "Show", targetState = true, onClick = onClick)
//            CustomButton(text = "Hide", targetState = false, onClick = onClick)

        }

        Spacer(modifier = Modifier.padding(20.dp))

        // 애니메이션 효과 추가
        AnimatedVisibility(
            visible = boxVisible,
//            visibleState = state,
//            enter = fadeIn(),
//            enter = fadeIn() + expandHorizontally(), // + 로 애니메이션 효과 조합 가능

//             애니메이션 동작 시간 설정
//            enter = fadeIn(animationSpec = tween(durationMillis = 5000)),

//            애니메이션 반복 - RepeatableSpec 서브클래스 이용
            enter = fadeIn(
                animationSpec = repeatable(10, animation = tween(durationMillis = 2000),
                    repeatMode = RepeatMode.Reverse)
            ),
            exit = slideOutVertically()
        ) {
            Box(modifier = Modifier
                .size(height = 200.dp, width = 200.dp)
                .background(Color.Green))
        }

    }

}

@Composable
fun CustomButton(text : String, targetState: Boolean,
                 onClick: (Boolean)-> Unit, bgColor : Color = Color.Blue){
    Button(
        onClick = { onClick(targetState) },
        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor,
            contentColor = Color.White)) {
        Text(text)
    }
}