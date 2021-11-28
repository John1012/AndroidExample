package com.example.androidexample.remote

import com.example.androidexample.remote.dao.PostRequest
import com.example.androidexample.remote.dao.PostResponse
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface PostsService {
    suspend fun getPosts(): List<PostResponse>
    suspend fun createPost(post: PostRequest): PostResponse?

    companion object {
        fun create(client: HttpClient): PostsService {
            return PostsServiceImpl(httpClient = client)
        }
    }
}