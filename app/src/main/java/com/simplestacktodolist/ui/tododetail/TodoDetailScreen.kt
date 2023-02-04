package com.simplestacktodolist.ui.tododetail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.simplestacktodolist.data.model.Todo

@Composable
fun TodoDetailScreen(todo: Todo) {
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
        Text(todo.toString())
    }
}
