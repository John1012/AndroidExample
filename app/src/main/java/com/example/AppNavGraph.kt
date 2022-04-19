package com.example

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.remote.dao.Candidate
import com.example.ui.HomeScreen
import com.example.ui.ResumeScreen
import kotlinx.coroutines.CoroutineScope

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = AppDestination.RESUME_ROUTE
    ) {
        composable(AppDestination.HOME_ROUTE) {
            HomeScreen()
        }
        composable(AppDestination.RESUME_ROUTE) {
            ResumeScreen(Candidate.JohnChang)
        }
    }
}