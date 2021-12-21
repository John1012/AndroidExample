package com.example.androidexample.data.repository

import com.example.androidexample.data.TodoDAO
import com.example.androidexample.data.models.TodoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class TodoRepository @Inject constructor(private val todoDAO: TodoDAO) {

    val getAllTasks: Flow<List<TodoTask>> = todoDAO.getAllTasks()
    val sortByLowPriority: Flow<List<TodoTask>> = todoDAO.sortByLowPriority()
    val sortByHighPriority: Flow<List<TodoTask>> = todoDAO.sortByHighPriority()

    fun getSelectedTask(taskId: Int): Flow<TodoTask> {
        return todoDAO.getSelectedTask(taskId)
    }

    suspend fun addTask(task: TodoTask) {
        todoDAO.addTask(task)
    }

    suspend fun updateTask(task: TodoTask) {
        todoDAO.updateTask(task)
    }

    suspend fun deleteTask(task: TodoTask) {
        todoDAO.deleteTask(task)
    }

    suspend fun deleteAllTasks() {
        todoDAO.deleteAllTasks()
    }

    fun searchDatabase(searchQuery: String): Flow<List<TodoTask>> {
        return todoDAO.searchDatabase(searchQuery)
    }
}