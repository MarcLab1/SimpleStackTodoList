package com.simplestacktodolist.ui.todolist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.simplestacktodolist.data.model.Todo
import com.simplestacktodolist.data.repository.TodoRepository
import com.zhuinden.simplestack.ScopedServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TodoListViewModel(
    private val todoRepository: TodoRepository,
) : ScopedServices.Registered {

    var todos: MutableState<List<Todo>> = mutableStateOf(emptyList())

    override fun onServiceRegistered() {
        CoroutineScope(Dispatchers.IO).launch {
            todoRepository.getTodos().collectLatest {
                todos.value = it
            }
        }
    }

    override fun onServiceUnregistered() {
        todos = mutableStateOf(emptyList())
    }

    fun removeTodoById(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            todoRepository.removeTodoById(id)
        }
    }
}