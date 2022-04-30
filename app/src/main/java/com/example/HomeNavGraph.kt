package com.example

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ui.RallyScreen

object AppDestination {
    const val RALLY_ROUTE = "rally"
}

@Composable
fun HomeNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.RALLY_ROUTE
    ) {
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