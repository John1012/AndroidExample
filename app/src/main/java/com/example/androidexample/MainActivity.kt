package com.example.androidexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.androidexample.remote.PostsService
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val postsService = PostsService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            val posts = postsService.getPosts()
            posts.forEach {
                Log.d("John", "Post: $it")
            }
        }
    }
}