package com.example.androidexample.di

import com.example.androidexample.remote.NewsRepository
import com.example.androidexample.remote.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsRepositoryModule {
    @Provides
    @Singleton
    fun provideNewRepository(
        client: HttpClient
    ): NewsRepository = NewsRepositoryImpl(client)
}