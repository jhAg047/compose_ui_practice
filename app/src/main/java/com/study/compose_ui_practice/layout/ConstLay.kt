package com.study.compose_ui_practice.layout

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController

// Constraint Layout
@Composable
fun ConstLay(navController: NavController) {

    ConstraintLayout(Modifier.size(width = 200.dp, height = 200.dp)) {
        // 참조 사용
        val (button1, button2, button3) = createRefs()

        // constrainAs()로 참조를 할당
        MyButton(text = "Button1", Modifier.constrainAs(button1){
            /*
            // 중앙배치 1
            start.linkTo(parent.start)
            end.linkTo(parent.end)

            // 중앙배치 2
            linkTo(parent.start,parent.end)

            // 중앙배치 3
            centerVerticallyTo(parent)
            centerHorizontallyTo(parent)
            */
            centerHorizontallyTo(parent)
            top.linkTo(parent.top)
            bottom.linkTo(button2.top)
        })

        MyButton(text = "Button2", Modifier.constrainAs(button2){
            centerHorizontallyTo(parent)
            top.linkTo(button1.bottom)
            bottom.linkTo(parent.bottom)
            // java xml constraintLayout app:layout_constraint위치_to위치Of 같은거?
        })
    }
}

@Composable
fun MyButton(text:String, modifier: Modifier = Modifier) {
    Button(
        onClick = { },
        modifier = modifier
    ) {
        Text(text)
    }
}