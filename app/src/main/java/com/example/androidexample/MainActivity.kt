package com.example.androidexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.example.androidexample.remote.PostsService
import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.HttpClient
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var httpClient: HttpClient

    private val postsService: PostsService by lazy {
        PostsService.create(httpClient)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            val posts = postsService.getPosts()
            posts.forEach {
                Log.d("John", "Post:$it")
            }
        }
    }
}

