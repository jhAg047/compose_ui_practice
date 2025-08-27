package com.study.compose_ui_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.compose_ui_practice.ui.theme.Compose_ui_practiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_ui_practiceTheme {
                MainScreen(
                    "Main",
                    Modifier.padding(10.dp)
                )
            }
        }
    }
}

// Compose UI 실습 기본 화면
@Composable
fun MainScreen(text: String, modifier: Modifier = Modifier){
    Text(
        text,
        modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    Compose_ui_practiceTheme {
        MainScreen("Main")
    }
}