package com.study.compose_ui_practice.layout

import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CustomLay(navController: NavController) {

    Box() {
        DoNothingLayout(Modifier.padding(8.dp)) {
            Text("Text Line 1")
            Text("Text Line 2")
            Text("Text Line 3")
            Text("Text Line 4")
        }
    }

    Box() {
        CascadeLayout(spacing = 20) {
            Box(modifier = Modifier.size(50.dp).background(Color.Blue))
            Box(modifier = Modifier.size(80.dp, 40.dp).background(Color.Red))
            Box(modifier = Modifier.size(90.dp,100.dp).background(Color.Green))
            Box(modifier = Modifier.size(70.dp).background(Color.Magenta))
        }
    }
}

@Composable
fun DoNothingLayout(
    modifier: Modifier = Modifier,
    content : @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        val placeables = measurables.map { measurable ->
            //  각 자식들을 측정
            measurable.measure(constraints)
        }
        layout(constraints.maxWidth, constraints.maxHeight) {
            placeables.forEach { placeable ->
                placeable.placeRelative(x = 0, y = 0)
            }
        }
    }
}

@Composable
fun CascadeLayout(
    spacing: Int = 0,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        var indent = 0

        layout(constraints.maxWidth, constraints.maxHeight) {
            var yCoord = 0
            val placeables = measurables.map { measurable ->
                measurable.measure(constraints)
            }
            placeables.forEach { placeable ->
                placeable.placeRelative(x = indent, y = yCoord)
                // 현재 위치 + 현재 자식의 폭(높이)
                indent += placeable.width + spacing
                yCoord += placeable.height + spacing
            }
        }

    }
}
