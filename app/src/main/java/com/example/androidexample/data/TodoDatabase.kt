package com.example.androidexample.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidexample.data.models.TodoTask

@Database(entities = [TodoTask::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDAO(): TodoDAO
}