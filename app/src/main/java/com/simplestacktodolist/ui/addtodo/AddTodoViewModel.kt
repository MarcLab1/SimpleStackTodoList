package com.simplestacktodolist.ui.addtodo

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.simplestacktodolist.data.model.Todo
import com.simplestacktodolist.data.repository.TodoRepository
import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestack.ScopedServices
import com.zhuinden.simplestack.ServiceBinder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AddTodoViewModel(
    private val backstack: Backstack,
    private val todoRepository: TodoRepository,
) : ScopedServices {

    var description: MutableState<String> = mutableStateOf("")

    fun insertTodo() {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                todoRepository.insertTodo(
                    Todo(
                        description = description.value,
                        date = System.currentTimeMillis()
                    )
                )
            }
        } catch (ex: Exception) {
            return
        }
        backstack.goBack()
    }

    override fun bindServices(serviceBinder: ServiceBinder) {

    }

}