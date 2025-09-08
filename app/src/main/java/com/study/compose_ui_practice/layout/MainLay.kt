package com.study.compose_ui_practice.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.study.compose_ui_practice.NavRoutes
import com.study.compose_ui_practice.bottomNav.BtNavBarItems

// 초기화면
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLay(navController: NavController) {

    Scaffold(
        topBar = { TopAppBar(title = { Text("Compose Practice") }) },
        content = { innerPadding ->
            MainButtonView(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                navController = navController)
                  },
        bottomBar = { BottomNavigationBar(navController = navController) }
    )

}

@Composable
fun MainButtonView(navController: NavController,modifier: Modifier = Modifier){
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

@Composable
fun BottomNavigationBar(navController: NavController){

    NavigationBar {

        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        BtNavBarItems.BarItems.forEach { navItem ->
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(imageVector = navItem.image,
                        contentDescription = navItem.title)
                },
                label = {
                    Text(text = navItem.title)
                }
            )

        }

    }

}