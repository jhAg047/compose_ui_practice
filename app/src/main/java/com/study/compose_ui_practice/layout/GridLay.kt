package com.study.compose_ui_practice.layout

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun GridLay(navController: NavController) {
     /*
     LazyVerticalGrid 컴보저블 사용
     그리드의 형태는 cells을 통해서 제어
     적응 모드 or 고정 모드로 설정 가능
     적응 모드 : 그리드가 이용할 수 있는 공간에 맞게 행과 열의 수를 계산, 이때 아이템 사이의 공간은 최소 지정 셀 크기
     고정 모드 : 표시할 행의 수를 전달하면 이용할 수 있는 공간의 폭을 채우기 위해 각 열의 폭을 동일한 크기로 조정
     */

    Column (
        modifier = Modifier.padding(5.dp)
            .fillMaxSize()
    ) {
        AdaptiveGrid(
            Modifier.weight(1f)
        )
        Spacer(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
        )
        FixedGrid(
            Modifier.weight(1f)
        )
    }

}

@Composable
fun AdaptiveGrid(modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 100.dp),
        state = rememberLazyGridState(),
        contentPadding = PaddingValues(10.dp),
        modifier = modifier
    ) {
        items(300) { index ->
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.Blue
                ),
                modifier = Modifier.padding(5.dp).fillMaxSize()
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "$index",
                        fontSize = 15.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun FixedGrid(modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        state = rememberLazyGridState(),
        contentPadding = PaddingValues(10.dp),
        modifier = modifier
    ) {
        items(15) { index ->
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.Green
                ),
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "$index",
                        fontSize = 15.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }

        }
    }

}