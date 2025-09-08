package com.study.compose_ui_practice.bottomNav

import androidx.compose.ui.graphics.vector.ImageVector

data class BarItem(
    val title:String,
    val image:ImageVector,
    val route:String
)