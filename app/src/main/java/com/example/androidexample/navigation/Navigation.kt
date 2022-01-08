package com.example.androidexample.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.androidexample.navigation.destinations.listComposable
import com.example.androidexample.navigation.destinations.taskComposable
import com.example.androidexample.ui.viewmodels.SharedViewModel
import com.example.androidexample.utils.Constants.LIST_SCREEN

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun SetupNavigation(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screens = remember(navHostController) {
        Screens(navHostController)
    }

    NavHost(navController = navHostController, startDestination = LIST_SCREEN ) {
        listComposable(navigateToTaskScreen = screens.task, sharedViewModel = sharedViewModel)
        taskComposable(navigateToListScreen = screens.list, sharedViewModel = sharedViewModel)
    }
}