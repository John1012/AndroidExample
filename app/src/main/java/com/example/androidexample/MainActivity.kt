package com.example.androidexample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidexample.remote.PostsService
import com.example.androidexample.remote.dao.PostResponse
import com.example.ktorexample.ui.theme.AndroidExampleTheme

class MainActivity : AppCompatActivity() {

    val postsService = PostsService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val posts = produceState<List<PostResponse>>(
                initialValue = emptyList(),
                producer = {
                    value = postsService.getPosts()
                }
            )
            AndroidExampleTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn {
                        items(posts.value) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(text = it.title, fontSize = 20.sp)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(text = it.body, fontSize = 16.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}

