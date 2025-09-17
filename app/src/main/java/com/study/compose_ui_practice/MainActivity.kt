package com.study.compose_ui_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.study.compose_ui_practice.bottomNav.BtNavRoutes
import com.study.compose_ui_practice.bottomNav.Contacts
import com.study.compose_ui_practice.bottomNav.Favorites
import com.study.compose_ui_practice.bottomNav.Home
import com.study.compose_ui_practice.layout.AnimateLay
import com.study.compose_ui_practice.layout.BoxLay
import com.study.compose_ui_practice.layout.CanvasLay
import com.study.compose_ui_practice.layout.ConstLay
import com.study.compose_ui_practice.layout.CustomLay
import com.study.compose_ui_practice.layout.GestureLay
import com.study.compose_ui_practice.layout.GridLay
import com.study.compose_ui_practice.layout.LazyListLay
import com.study.compose_ui_practice.layout.LazyRowCol
import com.study.compose_ui_practice.layout.MainLay
import com.study.compose_ui_practice.layout.ProductLay
import com.study.compose_ui_practice.layout.RowCol
import com.study.compose_ui_practice.layout.StateAnimateLay
import com.study.compose_ui_practice.layout.SwipeLay
import com.study.compose_ui_practice.layout.ViewModelLay
import com.study.compose_ui_practice.ui.theme.Compose_ui_practiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_ui_practiceTheme {
                MainScreen(
                    Modifier.padding(10.dp)
                )
            }
        }
    }
}

// Compose UI 실습 기본 화면
@Composable
fun MainScreen(modifier: Modifier = Modifier){

    // 초기화면 : MainLay.kt

    // 내비게이션 추가
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.MainLay.routes
    ) {
        // Main Layout
        composable(NavRoutes.MainLay.routes){
            MainLay(navController)
        }

        // Row and Column Layout
        composable(NavRoutes.RowCol.routes) {
            RowCol(navController)
        }

        // LazyRow and LazyColumn Layout
        composable(NavRoutes.LazyRowCol.routes) {
            LazyRowCol(navController)
        }

        // LazyRow and LazyColumn 2
        composable(NavRoutes.LazyListLay.routes){
            LazyListLay(navController)
        }

        // Box Layout
        composable(NavRoutes.BoxLay.routes) {
            BoxLay(navController)
        }

        // Constraint Layout
        composable(NavRoutes.ConstLay.routes) {
            ConstLay(navController)
        }

        // Custom Layout
        composable(NavRoutes.CustomLay.routes){
            CustomLay(navController)
        }

        // Grid Layout
        composable(NavRoutes.GridLay.routes){
            GridLay(navController)
        }

        // Animate Layout
        composable(NavRoutes.AnimateLay.routes){
            AnimateLay(navController)
        }

        // State Animate Layout
        composable(NavRoutes.StateAnimateLay.routes){
            StateAnimateLay(navController)
        }

        // Canvas Layout
        composable(NavRoutes.CanvasLay.routes){
            CanvasLay(navController)
        }

        // ViewModel Layout -> 수정 예정
        /*composable(NavRoutes.ViewModelLay.routes){
            val vm:MyViewModel = hiltViewModel()
            ViewModelLay(navController,vm)
        }*/

        // Gestures Layout
        composable(NavRoutes.GestureLay.routes) {
            GestureLay(navController)
        }

        // Swipe Gesture Lay
        composable(NavRoutes.SwipeLay.routes) {
            SwipeLay(navController)
        }

        // Room DB Product Lay
        composable(NavRoutes.ProductLay.routes) {
            ProductLay(navController)
        }

        // bottom navigation
        composable(BtNavRoutes.Home.route){
            Home()
        }
        composable(BtNavRoutes.Contacts.route){
            Contacts()
        }
        composable(BtNavRoutes.Favorites.route){
            Favorites()
        }

    }

}



@Preview(showBackground = true)
@Composable
fun MainPreview() {
    Compose_ui_practiceTheme {
        MainScreen()
    }
}