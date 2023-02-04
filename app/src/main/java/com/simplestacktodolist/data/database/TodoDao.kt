package com.simplestacktodolist.data.database

import androidx.room.*
import com.simplestacktodolist.data.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)

    @Update
    suspend fun updateTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)

    @Query("SELECT * FROM Todo")
    fun getTodos(): Flow<List<Todo>>

    @Query("SELECT * FROM Todo WHERE id = :id")
    fun getTodo(id : Int): Flow<Todo>
}