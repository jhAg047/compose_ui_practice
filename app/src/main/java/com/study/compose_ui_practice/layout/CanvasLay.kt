package com.study.compose_ui_practice.layout

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.draw
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.study.compose_ui_practice.R
import kotlin.math.sin
import kotlin.math.PI

// Canvas Layout
@Composable
fun CanvasLay(navController: NavController) {

    val scrollState = rememberScrollState()

    Column(modifier = Modifier.verticalScroll(scrollState).fillMaxSize()) {
        DrawLine()
        DrawRect()
        DrawRotateRect()
        DrawCircle()
        DrawOval()
        GradientFill()
        ShadowCircle()
        DrawArc()
        DrawPath()
        DrawPoints()
        DrawImage()

    }

}

@Composable
fun DrawLine() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val height = size.height
        val width = size.width

        drawLine(
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = width, y = height),
            color = Color.Blue,
            strokeWidth = 16.0f,
            pathEffect = PathEffect.dashPathEffect(
                floatArrayOf(30f,10f,10f,10f), phase = 0f)
        )
    }
}

@Composable
fun DrawRect() {
    Canvas(modifier = Modifier.size(300.dp)) {
        // Canvas의 크기는 밀도 독립 픽셀(인치당 도트 수로 정의되는 화면의 물리적 밀도를 기반으로 계산되는 추상적인 측정값)
        // 사각형의 크기는 픽셀(화면의 실제 물리적인 픽셀)
        //
//        val size = Size(200.dp.toPx(), 100.dp.toPx())
        //inset - Canvas 컴포넌트의 경계 설정 가능
        /*inset(100f, 200f) {
            drawRect(
                color = Color.Blue,
                topLeft = Offset(x = 350f, y = 300f),
                size = size / 2f
            )
        }*/

        // 테두리만 가진 사각형
        val size = Size(
            width = 280.dp.toPx(),
            height = 200.dp.toPx()
        )

        drawRoundRect(
            color = Color.Green,
            size = size,
            topLeft = Offset(20f, 20f),
            style = Stroke(width = 8.dp.toPx()),
            cornerRadius = CornerRadius(
                x = 30.dp.toPx(),
                y = 30.dp.toPx()
            )
        )
    }
}

@Composable
fun DrawRotateRect() {
    Canvas(modifier = Modifier.size(300.dp)) {
        rotate(45f) {
            drawRect(
                color = Color.Green,
                topLeft = Offset(200f, 200f),
                size = size / 2f
            )
        }
    }
}

@Composable
fun DrawCircle() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        drawCircle(
            color = Color.Green,
            center = center,
            radius = 120.dp.toPx()
        )
    }
}

@Composable
fun DrawOval(){
    Canvas(modifier = Modifier.size(300.dp)) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawOval(
            color = Color.Green,
            topLeft = Offset(x = 25.dp.toPx(), y = 90.dp.toPx()),
            size = Size(
                width = canvasWidth - 50.dp.toPx(),
                height = canvasHeight / 2 - 50.dp.toPx()
            ),
            style = Stroke(width = 12.dp.toPx())
        )
    }
}

@Composable
fun GradientFill(){
    Canvas(modifier = Modifier.size(300.dp)) {
        val canvasSize = size
        val colorList : List<Color> = listOf(Color.Red, Color.Blue,
            Color.Magenta, Color.Yellow, Color.Green, Color.Cyan)

        val brush = Brush.horizontalGradient(
            colors = colorList,
            startX = 0f,
            endX = 300.dp.toPx(),
            tileMode = TileMode.Repeated
        )

        drawRect(
            brush = brush,
            size = canvasSize
        )
    }
}

@Composable
fun ShadowCircle() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val radius = 150.dp.toPx()
        val colorList: List<Color> =
            listOf(Color.Green, Color.Black)

        val brush = Brush.horizontalGradient(
            colors = colorList,
            startX = 0f,
            endX = 300.dp.toPx(),
            tileMode = TileMode.Repeated
        )

        drawCircle(
            brush = brush,
            radius = radius
        )
    }
}

@Composable
fun DrawArc() {
    Canvas(modifier = Modifier.size(300.dp)) {
        drawArc(
            Color.Green,
            startAngle = 20f,
            sweepAngle = 90f,
            useCenter = true,
            size = Size(250.dp.toPx(), 250.dp.toPx())
        )
    }
}

@Composable
fun DrawPath() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val path = Path().apply {
            moveTo(0f,0f)
            quadraticTo(50.dp.toPx(), 200.dp.toPx(),
                300.dp.toPx(), 300.dp.toPx())
            lineTo(270.dp.toPx(),100.dp.toPx())
            quadraticTo(60.dp.toPx(), 80.dp.toPx(),0f,0f)
            close()
        }
        drawPath(
            path = path,
            Color.Green
        )
    }
}

@Composable
fun DrawPoints(){
    Canvas(modifier = Modifier.size(300.dp)) {
        val height = size.height
        val width = size.width
        val points = mutableListOf<Offset>()

        for(x in 0..size.width.toInt()) {
            val y = (sin(x * (2f * PI / width))
                    * (height / 2) + (height / 2)).toFloat()
            points.add(Offset(x.toFloat(),y))
        }

        drawPoints(
            points = points,
            strokeWidth = 3f,
            pointMode = PointMode.Points,
            color = Color.Blue
        )

    }
}

@Composable
fun DrawImage(){
    val image = ImageBitmap.imageResource(id = R.drawable.poncho)

    Canvas(
        modifier = Modifier
            .size(360.dp, 270.dp)
    ) {
        drawImage(
            image = image,
            topLeft = Offset(x = 0f, y = 0f)
        )
    }
}