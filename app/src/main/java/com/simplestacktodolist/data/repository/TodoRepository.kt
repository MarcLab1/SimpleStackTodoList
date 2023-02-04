package com.simplestacktodolist.data.repository

import com.simplestacktodolist.data.database.TodoDao
import com.simplestacktodolist.data.database.TodoDatabase
import com.simplestacktodolist.data.model.Todo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class TodoRepository(private val db: TodoDatabase) {

    private var dao: TodoDao

    init {
        dao = db.todoDao()
    }

    fun getTodos(): Flow<List<Todo>> {
        return dao.getTodos()
    }

    suspend fun insertTodo(todo: Todo) {
        dao.insertTodo(todo)
    }

    suspend fun removeTodoById(id: Int) {
        dao.deleteTodo(db.todoDao().getTodo(id).first())
    }

    suspend fun removeTodo(todo: Todo) {
        dao.deleteTodo(todo)
    }

    suspend fun updateTodo(todo: Todo) {
        dao.updateTodo(todo)
    }
}