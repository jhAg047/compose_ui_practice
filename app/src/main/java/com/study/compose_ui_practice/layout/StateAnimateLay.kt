package com.study.compose_ui_practice.layout

import android.widget.Button
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.Spring.DampingRatioHighBouncy
import androidx.compose.animation.core.Spring.StiffnessVeryLow
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.study.compose_ui_practice.R

// 상태 주도 애니메이션
@Composable
fun StateAnimateLay(navController: NavController) {
//    RotationDemo()
//    ColorChangeDemo()
    MotionDemo()
}

enum class BoxColor {
    Red, Green
}

@Composable
fun RotationDemo() {
    var rotated by remember { mutableStateOf(false) }

    val angle by animateFloatAsState(
        targetValue = if (rotated) 260f else 0f,
        animationSpec = tween(durationMillis = 2500, easing = LinearEasing)
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()) {
        Image(painter = painterResource(R.drawable.propeller),
            contentDescription = "fan",
            modifier = Modifier
                .rotate(angle)
                .padding(10.dp)
                .size(300.dp))

        Button(
            onClick = { rotated = !rotated },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Rotate Propeller")
        }

    }
}

@Composable
fun ColorChangeDemo(){

    var colorState by remember { mutableStateOf(BoxColor.Red) }

    val animatedColor: Color by animateColorAsState(
        targetValue = when (colorState) {
            BoxColor.Red -> Color.Green
            BoxColor.Green -> Color.Red
        },
        animationSpec = tween(4500)
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .padding(20.dp)
                .size(200.dp)
                .background(animatedColor)
        )

        Button(
            onClick = {
                colorState = when (colorState) {
                    BoxColor.Red -> BoxColor.Green
                    BoxColor.Green -> BoxColor.Red
                }
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Change Color")
        }
    }
}

// 움직임 애니메이션

enum class BoxPosition {
    Start, End
}

@Composable
fun MotionDemo(){
    var screenWidth = (LocalConfiguration.current.screenWidthDp.dp)
    var boxState by remember { mutableStateOf(BoxPosition.Start) }
    val boxSideLength = 70.dp

    /*val animatedOffset: Dp by animateDpAsState(
        targetValue = when (boxState) {
            BoxPosition.Start -> 0.dp
            BoxPosition.End -> screenWidth - boxSideLength
        },
//        animationSpec = tween(500)
        // 스프링 효과 - dampingRatio
        // 스프링 강도(세기) - stiffness
//        animationSpec = spring(dampingRatio = DampingRatioHighBouncy, stiffness = StiffnessVeryLow)

        // 키프레임 사용 - keyframes()
        // 애니메이션 타임라인의 특정한 지점에 다양한 유지 시간이나 이징값을 적용할 수 있음
        animationSpec = keyframes {
            durationMillis = 1000
            100.dp.at(10).using(LinearEasing)
            110.dp.at(500).using(FastOutSlowInEasing)
            200.dp.at(700).using(LinearOutSlowInEasing)
        }
    )*/

    val transition = updateTransition(targetState = boxState,
        label = "Color and Motion")

    // 여러 애니메이션 조합하기 - updateTransition()
    val animatedColor: Color by transition.animateColor(
        transitionSpec = {
            tween(4000)
        }
    ) { state ->
        when(state) {
            BoxPosition.Start -> Color.Red
            BoxPosition.End -> Color.Green
        }
    }

    val animatedOffset: Dp by transition.animateDp(
        transitionSpec = {
            tween(4000)
        }
    ) { state ->
        when (state) {
            BoxPosition.Start -> 0.dp
            BoxPosition.End -> screenWidth - 70.dp
        }

    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .offset(x = animatedOffset, y = 20.dp)
                .size(boxSideLength)
                .background(animatedColor)
        )

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = {
                boxState = when (boxState) {
                    BoxPosition.Start -> BoxPosition.End
                    BoxPosition.End -> BoxPosition.Start
                }
            },
            modifier = Modifier.padding(20.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Move Box")
        }

    }
}
