package com.example.androidexample.remote

import com.example.androidexample.remote.dao.News
import io.ktor.client.HttpClient

interface NewsRepository {
    suspend fun getNews(): List<News>
}