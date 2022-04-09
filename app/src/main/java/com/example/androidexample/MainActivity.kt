package com.example.androidexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.androidexample.screen.NewsScreen
import com.example.androidexample.screen.NewsViewModel
import com.example.androidexample.ui.theme.AndroidExampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val newsViewModel: NewsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidExampleTheme {
                NewsScreen(viewModel = newsViewModel)
            }
        }
    }
}

