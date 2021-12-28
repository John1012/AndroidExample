package com.example.androidexample.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.androidexample.data.models.Priority
import com.example.androidexample.data.models.TodoTask
import com.example.androidexample.ui.viewmodels.SharedViewModel
import com.example.androidexample.utils.Action

@Composable
fun TaskScreen(
    todoTask: TodoTask?,
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    Scaffold(
        topBar = {
            TaskAppBar(
                todoTask = todoTask,
                navigateToListScreen = navigateToListScreen
            )
        },
        content = {
            TaskContent(
                title = title,
                onTitleChanged = { sharedViewModel.title.value = it },
                description = description,
                onDescriptionChanged = { sharedViewModel.description.value = it},
                priority = priority,
                onPrioritySelected = { sharedViewModel.priority.value = it }
            )
        }
    )
}