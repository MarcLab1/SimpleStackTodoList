package com.simplestacktodolist.ui.todolist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import com.simplestacktodolist.ComposeKey
import com.simplestacktodolist.TodoListScreen
import com.simplestacktodolist.data.repository.TodoRepository
import com.zhuinden.simplestack.ServiceBinder
import com.zhuinden.simplestackcomposeintegration.services.rememberService
import com.zhuinden.simplestackextensions.servicesktx.add
import com.zhuinden.simplestackextensions.servicesktx.lookup
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class TodoListKey(private val noArgsPlaceholder: String = "") : ComposeKey() {

    @Composable
    override fun ScreenComposable(modifier: Modifier) {
        val viewModel = rememberService<TodoListViewModel>()

        TodoListScreen(
            todos = viewModel.todos.value,
            onRemoveTodoById = { id -> viewModel.removeTodoById(id) },
            modifier = modifier
        )
    }

    override fun bindServices(serviceBinder: ServiceBinder) {
        with(serviceBinder) {
            val firstModel = TodoListViewModel(lookup<TodoRepository>())
            add(firstModel)
        }
    }
}