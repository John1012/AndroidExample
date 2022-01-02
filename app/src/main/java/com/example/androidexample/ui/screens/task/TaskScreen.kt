package com.example.androidexample.ui.screens.task

import android.content.Context
import android.widget.Toast
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
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
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TaskAppBar(
                todoTask = todoTask,
                navigateToListScreen = { action ->
                    if (action == Action.NO_ACTION) {
                        navigateToListScreen(Action.NO_ACTION)
                    } else {
                        if (sharedViewModel.validateFields()) {
                            navigateToListScreen(action)
                        } else {
                            displayToast(context)
                        }
                    }

                }
            )
        },
        content = {
            TaskContent(
                title = title,
                onTitleChanged = { sharedViewModel.updateTitle(it) },
                description = description,
                onDescriptionChanged = { sharedViewModel.description.value = it},
                priority = priority,
                onPrioritySelected = { sharedViewModel.priority.value = it }
            )
        }
    )
}

fun displayToast(context: Context) {
    Toast.makeText(
        context,
        "Fields Empty",
        Toast.LENGTH_SHORT
    ).show()
}