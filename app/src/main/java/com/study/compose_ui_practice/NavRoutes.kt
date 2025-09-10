package com.study.compose_ui_practice

// 내비게이션 경로 선언을 위한 클래스
sealed class NavRoutes(val routes: String) {
    object MainLay : NavRoutes("MainLay")
    object RowCol : NavRoutes("RowCol")
    object LazyRowCol : NavRoutes("LazyRowCol")
    object BoxLay : NavRoutes("BoxLay")
    object ConstLay : NavRoutes("ConstLay")
    object CustomLay : NavRoutes("Custom")
    object LazyListLay : NavRoutes("LazyList")
    object GridLay : NavRoutes("GridLay")
    object AnimateLay : NavRoutes("AnimateLay")
    object StateAnimateLay : NavRoutes("StateAnimateLay")
    object CanvasLay : NavRoutes("CanvasLay")
    object ViewModelLay : NavRoutes("ViewModelLay")
    object GestureLay : NavRoutes("Gesture")
}