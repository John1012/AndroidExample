package com.example.remote

import com.example.remote.dao.PostRequest
import com.example.remote.dao.PostResponse
import io.ktor.client.*

interface PostsService {
    suspend fun getPosts(): List<PostResponse>
    suspend fun createPost(post: PostRequest): PostResponse?

    companion object {
        fun create(client: HttpClient): PostsService {
            return PostsServiceImpl(httpClient = client)
        }
    }
}