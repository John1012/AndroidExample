package com.example.androidexample.remote

import com.example.androidexample.remote.dao.PostRequest
import com.example.androidexample.remote.dao.PostResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

class PostsServiceImpl(
    private val httpClient: HttpClient
) : PostsService {

    override suspend fun getPosts(): List<PostResponse> {
        return try {
            httpClient.get { url(HttpRoutes.POSTS) }
        } catch (e: RedirectResponseException) {
            // 3xx - response
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ClientRequestException) {
            // 4xx - response
            println("Error: ${e.response.status.description} ")
            emptyList()
        } catch (e: ServerResponseException) {
            // 5xx - response
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e : Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }

    override suspend fun createPost(post: PostRequest): PostResponse? {
        return try {
            httpClient.post{
                url(HttpRoutes.POSTS)
                contentType(ContentType.Application.Json)
                body = post
            }
        } catch (e: RedirectResponseException) {
            // 3xx - response
            println("Error: ${e.response.status.description}")
            null
        } catch (e: ClientRequestException) {
            // 4xx - response
            println("Error: ${e.response.status.description} ")
            null
        } catch (e: ServerResponseException) {
            // 5xx - response
            println("Error: ${e.response.status.description}")
            null
        } catch (e : Exception) {
            println("Error: ${e.message}")
            null
        }
    }
}