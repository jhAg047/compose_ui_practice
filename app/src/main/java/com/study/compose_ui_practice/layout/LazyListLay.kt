package com.study.compose_ui_practice.layout

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.study.compose_ui_practice.R
import kotlinx.coroutines.launch

@Composable
fun LazyListLay(navController: NavController) {
//    ColumnList()
    LazyListDemo()

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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyListDemo(){

    // LazyList 실습 및 xml 파일로 이미지 읽어오기

    val context = LocalContext.current

    var itemArray: Array<String>? = null
    itemArray = context.resources.getStringArray(R.array.car_array)

    // 이미지 자동 로딩 라이브러리 Coil test
    /*ImageLoader("Plymouth GTX")
    MyListItem("Buick Roadmaster")*/

    val onListItemClick = { text : String ->
        Toast.makeText(
            context,
            text,
            Toast.LENGTH_SHORT
        ).show()
    }

    /*LazyColumn {
        items(itemArray) { model ->
            MyListItem(item = model, onItemClick = onListItemClick)
        }
    }*/

    val groupedItems = itemArray.groupBy { it.substringBefore(' ') }

    // 스크롤 위치 식별하기
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val displayButton = listState.firstVisibleItemIndex > 5

    Box {
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(bottom = 40.dp)
        ) {
            groupedItems.forEach { (manufacturer, models) ->

                // 스티키 헤더 추가하기
                stickyHeader {
                    Text(
                        text = manufacturer,
                        color = Color.White,
                        modifier = Modifier
                            .background(Color.Gray)
                            .padding(5.dp)
                            .fillMaxWidth()
                    )
                }

                items(models) { model ->
                    MyListItem(item = model, onItemClick = onListItemClick)
                }
            }
        }
        // 스크롤 버튼 추가
        AnimatedVisibility(visible = displayButton,
                Modifier.align(Alignment.BottomCenter)) {

            OutlinedButton(
                onClick = {
                    coroutineScope.launch {
                        listState.scrollToItem(0)
                    }
                },
                border = BorderStroke(1.dp,Color.Gray),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.DarkGray
                ),
                modifier = Modifier.padding(5.dp)
            ) {
                Text(text = "Top")
            }

        }

    }

}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ImageLoader(item:String){
    // 웹사이트에서 이미지 불러오는 함수

    val url = "https://www.ebookfrenzy.com/book_examples/car_logos/" +
            item.substringBefore(" ") + "_logo.png"

    Image(
        painter = rememberImagePainter(url),
        contentDescription = "car image",
        contentScale = ContentScale.Fit,
        modifier = Modifier.size(75.dp)
    )

}

@Composable
fun MyListItem(item:String,onItemClick: (String) -> Unit){

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onItemClick(item) },
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ImageLoader(item)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = item,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

}