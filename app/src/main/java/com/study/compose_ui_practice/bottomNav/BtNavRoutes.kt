package com.study.compose_ui_practice.bottomNav

sealed class BtNavRoutes(val route:String) {
    object Home : BtNavRoutes("home")
    object Contacts : BtNavRoutes("contacts")
    object Favorites : BtNavRoutes("favorites")

}