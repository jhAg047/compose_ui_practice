package com.study.compose_ui_practice

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.w3c.dom.Text

// Row and Column Layout
@Composable
fun RowCol(navController: NavController) {
    // Row Alignment = Vertically
    Row(modifier = Modifier
        .size(width = 400.dp, height=200.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextCell("1")
        TextCell("2")
        TextCell("3")
    }

    // Column Alignment = Horizontal
    Column(modifier = Modifier.width(250.dp),
        horizontalAlignment = Alignment.End
    ) {
        TextCell("1")
        TextCell("2")
        TextCell("3")
    }

    // Row + Column
    // 레이아웃 위치 조정
    Column(verticalArrangement = Arrangement.Center){
        Row {
            Column {
                TextCell("가")
                TextCell("나")
                TextCell("다")
            }
            Column {
                TextCell("라")
                TextCell("마")
                TextCell("바")
            }

            Column {
                TextCell("사")
                TextCell("아")
            }
        }
        Row {
            TextCell("도",Modifier.weight(weight = 0.2f, fill = true))
            TextCell("레",Modifier.weight(weight = 0.4f, fill = true))
            TextCell("미",Modifier.weight(weight = 0.3f, fill = true))
        }
    }
}

@Composable
fun TextCell(text:String, modifier: Modifier = Modifier) {

    val cellModifier = Modifier
            .padding(4.dp)
            .size(100.dp, 100.dp)
            .border(width = 4.dp, color = Color.Blue)

    Text(text = text,
        cellModifier.then(modifier),
        fontSize = 70.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center)

}