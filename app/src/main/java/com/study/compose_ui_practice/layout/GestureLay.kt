package com.study.compose_ui_practice.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

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