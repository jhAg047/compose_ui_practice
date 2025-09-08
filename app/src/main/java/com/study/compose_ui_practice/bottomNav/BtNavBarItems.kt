package com.study.compose_ui_practice.bottomNav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home

object BtNavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = "Home"
        ),
        BarItem(
            title = "Contacts",
            image = Icons.Filled.Face,
            route = "Contacts"
        ),
        BarItem(
            title = "Favorites",
            image = Icons.Filled.Favorite,
            route = "Favorites"
        ),

    )

}