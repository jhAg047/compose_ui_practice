package com.study.compose_ui_practice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun LazyListLay(navController: NavController) {
    ColumnList()
}

@Composable
fun ColumnList(){

    // 리스트 스크롤 활성화하기
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row {
            Button(onClick = {
                // 맨위로 스크롤
                coroutineScope.launch {
                    scrollState.animateScrollTo(0)
                }
            },
                modifier = Modifier.weight(0.5f)
                    .padding(2.dp)) {
                Text("TOP")
            }
            Button(onClick = {
                // 제일 아래로 스크롤
                coroutineScope.launch {
                    scrollState.animateScrollTo(scrollState.maxValue)
                }
            },
                modifier = Modifier.weight(0.5f)
                    .padding(2.dp)) {
                Text("End")
            }
        }
        Column (Modifier.verticalScroll(scrollState)){
            repeat(300) {
                Text("List item $it",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(5.dp))
            }
        }
    }

}