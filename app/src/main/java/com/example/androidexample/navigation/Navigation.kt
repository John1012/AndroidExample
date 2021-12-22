package com.example.androidexample.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.androidexample.navigation.destinations.listComposable
import com.example.androidexample.navigation.destinations.taskComposable
import com.example.androidexample.utils.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(
    navHostController: NavHostController
) {
    val screens = remember(navHostController) {
        Screens(navHostController)
    }

    NavHost(navController = navHostController, startDestination = LIST_SCREEN ) {
        listComposable(navigateToTaskScreen = screens.task)
        taskComposable(navigateToListScreen = screens.list)
    }
}