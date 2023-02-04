package com.simplestacktodolist.ui.addtodo

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.simplestacktodolist.data.model.Todo
import com.zhuinden.simplestackcomposeintegration.core.LocalBackstack

@Composable
fun AddTodoScreen(
    description: MutableState<String>,
    addTodo: (Todo) -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {

        TextField(value = description.value, onValueChange = { description.value = it })

        Button(onClick = {
            addTodo(
                Todo(
                    description = description.value,
                    date = System.currentTimeMillis()
                )
            )
        }) {
            Text("Add Todo")
        }
    }
}
