package com.simplestacktodolist.ui.addtodo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import com.simplestacktodolist.ComposeKey
import com.simplestacktodolist.data.repository.TodoRepository
import com.zhuinden.simplestack.ServiceBinder
import com.zhuinden.simplestackcomposeintegration.services.rememberService
import com.zhuinden.simplestackextensions.servicesktx.add
import com.zhuinden.simplestackextensions.servicesktx.lookup
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class AddTodoKey(val title: String = "") : ComposeKey() {
    @Composable
    override fun ScreenComposable(modifier: Modifier) {
        val viewModel = rememberService<AddTodoViewModel>()

        AddTodoScreen(description = viewModel.description, addTodo = { viewModel.insertTodo() })
    }

    override fun bindServices(serviceBinder: ServiceBinder) {
        with(serviceBinder) {
            val viewModel = AddTodoViewModel(backstack, lookup<TodoRepository>())
            add(viewModel)
        }
    }
}