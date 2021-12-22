package com.example.androidexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androidexample.navigation.SetupNavigation
import com.example.androidexample.remote.PostsService
import com.example.ktorexample.ui.theme.AndroidExampleTheme
import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.HttpClient
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidExampleTheme {
                navHostController = rememberNavController()
                SetupNavigation(navHostController = navHostController)
            }
        }
    }
}

