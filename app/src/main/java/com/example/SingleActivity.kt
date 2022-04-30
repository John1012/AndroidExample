package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.theme.AndroidExampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SingleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidExampleTheme {
                val navController = rememberNavController()
                HomeScreen(navController = navController)
            }
        }
    }
}

