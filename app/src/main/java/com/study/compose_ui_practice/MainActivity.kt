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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.study.compose_ui_practice.layout.BoxLay
import com.study.compose_ui_practice.layout.ConstLay
import com.study.compose_ui_practice.layout.CustomLay
import com.study.compose_ui_practice.layout.LazyRowCol
import com.study.compose_ui_practice.layout.MainLay
import com.study.compose_ui_practice.layout.RowCol
import com.study.compose_ui_practice.ui.theme.Compose_ui_practiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_ui_practiceTheme {
                MainScreen(
                    "Compose UI 실습",
                    Modifier.padding(10.dp)
                )
            }
        }
    }
}

// Compose UI 실습 기본 화면
@Composable
fun MainScreen(text: String, modifier: Modifier = Modifier){

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
    }

}



@Preview(showBackground = true)
@Composable
fun MainPreview() {
    Compose_ui_practiceTheme {
        MainScreen("Main")
    }
}