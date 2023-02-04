package com.simplestacktodolist.ui.tododetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import com.simplestacktodolist.ComposeKey
import com.simplestacktodolist.data.model.Todo
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class TodoDetailKey(val todo: Todo) : ComposeKey() {
    @Composable
    override fun ScreenComposable(modifier: Modifier) {
        TodoDetailScreen(todo = todo)
    }
}