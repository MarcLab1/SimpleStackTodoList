package com.simplestacktodolist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.simplestacktodolist.data.model.Todo
import com.simplestacktodolist.ui.*
import com.simplestacktodolist.ui.addtodo.AddTodoKey
import com.simplestacktodolist.ui.tododetail.TodoDetailKey
import com.zhuinden.simplestackcomposeintegration.core.LocalBackstack

class TodoListScreen {

    companion object {
        @Composable
        operator fun invoke(
            todos: List<Todo>,
            onRemoveTodoById: (Int) -> Unit,
            modifier: Modifier = Modifier
        ) {

            val backstack = LocalBackstack.current

            Column(
                modifier = modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(5.dp))
                Button(onClick = {
                    backstack.goTo(AddTodoKey())
                }) {
                    Text("Add new todo")
                }
                Spacer(modifier = Modifier.padding(5.dp))
                LazyColumn()
                {
                    items(todos)
                    { todo ->
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                backstack.goTo(TodoDetailKey(todo))
                            })
                        {
                            Text(todo.id.toString(), modifier = Modifier.weight(1F))
                            Text(todo.description, modifier = Modifier.weight(6F))
                            Text(
                                HelperDate.getDateFromLong(todo.date),
                                modifier = Modifier.weight(2.5F)
                            )
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "",
                                modifier = Modifier
                                    .weight(1F)
                                    .clickable {
                                        onRemoveTodoById(todo.id)
                                    }
                            )
                        }
                    }
                }
            }
        }
    }
}


