package com.study.compose_ui_practice.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlin.math.roundToInt

@Composable
fun GestureLay(navController: NavController) {



}

// 클릭 감지
@Composable
fun ClickDemo(){

    var colorState by remember { mutableStateOf(true) }
    var bgColor by remember { mutableStateOf(Color.Green) }

    val ClickHandler = {
        colorState = !colorState

        bgColor = if (colorState){
            Color.Green
        } else {
            Color.DarkGray
        }
    }
    Box(
        Modifier
            .clickable { ClickHandler() }
            .background(bgColor)
            .size(100.dp)
    )

}

// PointerInputScope 사용
@Composable
fun TapPressDemo(){
    var textState by remember { mutableStateOf("Waiting..") }

    val tapHandler = { status : String ->
        textState = status
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            Modifier
                .padding(10.dp)
                .background(Color.Green)
                .size(100.dp)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onPress = { tapHandler("onPress Detected") }, // 프레스
                        onDoubleTap = { tapHandler("onDouble Detected") }, // 더블 탭
                        onLongPress = { tapHandler("onLongPress Detected") }, // 롱 프레스
                        onTap = { tapHandler("onTap Detected") } // 탭
                    )
                }
        )
        Spacer(Modifier.height(10.dp))
        Text(textState)
    }
}

// 드레그 제스처 감지하기
@Composable
fun DragDemo(){

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        var xOffset by remember { mutableStateOf(0f) }


        // draggable() 모디파이어는 수평 / 수직으로만 제스처를 지원할 때 유용
        Box(
            modifier = Modifier
                .offset { IntOffset(xOffset.roundToInt(),0) }
                .size(100.dp)
                .background(Color.Green)
                .draggable(
                    orientation = Orientation.Horizontal,
                    state = rememberDraggableState { distance ->
                        xOffset += distance
                    }
                )
        )

    }

}

// PointerInputScope를 이용한 드래그 제스처 감지
@Composable
fun PointerInputDrag(){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        var xOffset by remember { mutableStateOf(0f) }
        var yOffset by remember { mutableStateOf(0f) }
        Box(
            Modifier
                .offset { IntOffset(xOffset.roundToInt(), yOffset.roundToInt()) }
                .background(Color.Green)
                .size(100.dp)
                .pointerInput(Unit) {
                    detectDragGestures { _, dragAmount ->
                        xOffset += dragAmount.x
                        yOffset += dragAmount.y
                    }
                }

        )
    }
}

// scrollable 모디파이어를 이용한 스크롤
@Composable
fun ScrollableModifier() {
    var offset by remember { mutableStateOf(0f) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(
                orientation = Orientation.Vertical,
                state = rememberScrollableState { distance ->
                    offset += distance
                    distance
                }
            )
    ) {
        Box(
            modifier = Modifier
                .size(90.dp)
                .offset { IntOffset(0, offset.roundToInt()) }
                .background(Color.Red)
        )
    }

}

