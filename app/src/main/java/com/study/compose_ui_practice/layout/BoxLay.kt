package com.study.compose_ui_practice.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// Box Layout
@Composable
fun BoxLay(navController: NavController) {
    Box {
        val height = 200.dp
        val width = 200.dp

        BoxTextCell("1",Modifier.size(width = width, height = height))
        BoxTextCell("2",Modifier.size(width = width, height = height))
        BoxTextCell("3",Modifier.size(width = width, height = height))

    }

    Box(modifier = Modifier.size(height = 90.dp, width = 290.dp)) {
        Text("TopStart",Modifier.align(Alignment.TopStart))
        Text("TopCenter",Modifier.align(Alignment.TopCenter))
        Text("TopEnd",Modifier.align(Alignment.TopEnd))

        Text("CenterStart",Modifier.align(Alignment.CenterStart))
        Text("Center",Modifier.align(Alignment.Center))
        Text("CenterEnd",Modifier.align(Alignment.CenterEnd))

        Text("BottomStart",Modifier.align(Alignment.BottomStart))
        Text("BottomCenter",Modifier.align(Alignment.BottomCenter))
        Text("BottomEnd",Modifier.align(Alignment.BottomEnd))

    }

    // clip 사용
    Box(Modifier.size(200.dp).clip(CircleShape).background(Color.Green))

    Box(Modifier.size(200.dp).clip(RoundedCornerShape(30.dp)).background(Color.Green))

    Box(Modifier.size(200.dp).clip(CutCornerShape(30.dp)).background(Color.Green))


}

@Composable
fun BoxTextCell(text:String, modifier: Modifier = Modifier) {

    val cellModifier = Modifier
        .padding(4.dp)
        .size(100.dp, 100.dp)
        .border(width = 4.dp, color = Color.Blue)

    Surface {
        Text(
            text = text,
            cellModifier.then(modifier),
            fontSize = 70.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}