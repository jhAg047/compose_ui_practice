package com.study.compose_ui_practice.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.study.compose_ui_practice.MyViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun ViewModelLay(navController: NavController, model : MyViewModel) {

    ViewModelCheck(model.customerCount) {model.increaseCount()}

}

@Composable
fun ViewModelCheck(count : Int, addCount:() -> Unit = {}) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()) {
        Text("Total customers = $count",
            Modifier.padding(10.dp))
        Button(
            onClick = addCount
        ) {
            Text(text = "Add a Customer")
        }
    }

}