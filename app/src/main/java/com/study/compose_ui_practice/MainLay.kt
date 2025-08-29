package com.study.compose_ui_practice

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// 초기화면
@Composable
fun MainLay(navController: NavController) {

    Box {
        val height = 200.dp
        val width = 200.dp

        BoxTextCell("1", Modifier.size(width = width, height = height))
        BoxTextCell("2", Modifier.size(width = width, height = height))
        BoxTextCell("3", Modifier.size(width = width, height = height))

    }

}