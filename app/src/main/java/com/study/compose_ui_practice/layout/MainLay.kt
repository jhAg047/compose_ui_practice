package com.study.compose_ui_practice.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.study.compose_ui_practice.NavRoutes

// 초기화면
@Composable
fun MainLay(navController: NavController) {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Column {
                Row {
                    Button(
                        onClick = { navController.navigate(NavRoutes.RowCol.routes) }
                    ) {
                        Text("RowCol")
                    }
                    Button(
                        onClick = { navController.navigate(NavRoutes.BoxLay.routes) }
                    ) {
                        Text("Box")
                    }
                    Button(
                        onClick = { navController.navigate(NavRoutes.CustomLay.routes) }
                    ) {
                        Text("Custom")
                    }
                }
                Row {
                    Button(
                        onClick = { navController.navigate(NavRoutes.ConstLay.routes) }
                    ) {
                        Text("ConstLay")
                    }
                    Button(
                        onClick = { navController.navigate(NavRoutes.LazyRowCol.routes) }
                    ) {
                        Text("Lazy")
                    }
                    Button(
                        onClick = { navController.navigate(NavRoutes.LazyListLay.routes) }
                    ) {
                        Text("Lazy2")
                    }

                }
                Row {
                    Button(
                        onClick = { navController.navigate(NavRoutes.GridLay.routes) }
                    ) {
                        Text("Grid")
                    }
                    Button(
                        onClick = { navController.navigate(NavRoutes.AnimateLay.routes) }
                    ) {
                        Text("Animate")
                    }
                    Button(
                        onClick = { navController.navigate(NavRoutes.StateAnimateLay.routes) }
                    ) {
                        Text("StateAnimate")
                    }

                    Button(
                        onClick = { navController.navigate(NavRoutes.CanvasLay.routes) }
                    ) {
                        Text("Canvas")
                    }

                }
            }

        }
    }

}