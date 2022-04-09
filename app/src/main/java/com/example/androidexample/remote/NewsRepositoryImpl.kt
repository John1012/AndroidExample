package com.example.androidexample.remote

import com.example.androidexample.remote.dao.News
import io.ktor.client.HttpClient
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class ServerException: Exception()

class NewsRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient,
) : NewsRepository {
    val newsList: List<News> = emptyList()
    override suspend fun getNews(): List<News> {
        return try {
            if (newsList.isEmpty())
                httpClient.get { url(HttpRoutes.NEWS_URL) }
            else
                newsList
        } catch (e: RedirectResponseException) {
            // 3xx - response
            println("Error: ${e.response.status.description}")
            throw ServerException()
        } catch (e: ClientRequestException) {
            // 4xx - response
            println("Error: ${e.response.status.description} ")
            throw ServerException()
        } catch (e: ServerResponseException) {
            // 5xx - response
            println("Error: ${e.response.status.description}")
            throw ServerException()
        } catch (e : Exception) {
            println("Error: ${e.message}")
            throw ServerException()
        }
    }

}