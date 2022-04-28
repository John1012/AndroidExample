package com.example

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ui.HomeScreen
import com.example.ui.RallyScreen
import com.example.ui.StateScreen

object AppDestination {
    const val HOME_ROUTE = "home"
    const val STATE_PRACTICE_ROUTE = "state"
    const val RALLY_ROUTE = "rally"
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = AppDestination.RALLY_ROUTE
    ) {
        composable(AppDestination.HOME_ROUTE) {
            HomeScreen()
        }
        composable(AppDestination.STATE_PRACTICE_ROUTE) {
            StateScreen()
        }
        composable(AppDestination.RALLY_ROUTE) {
            RallyScreen()
        }
        /* The example of creating screen
        val accountsName = RallyScreen.Accounts.name
        composable(
            route = "$accountsName/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                }
            ),
            deepLinks = listOf(
                navDeepLink { uriPattern = "rally://$accountsName/{name}" }
            )
        ) { entry ->
            val accountName = entry.arguments?.getString("name")
            val account = UserData.getAccount(accountName)
            SingleAccountBody(account)
        }
         */
    }
}