package com.example.androidexample.screen

import com.example.androidexample.CoroutinesTestRule
import com.example.androidexample.remote.NewsRepository
import com.example.androidexample.remote.ServerException
import com.example.androidexample.remote.dao.News

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class FakeNewRepository: NewsRepository {
    var isException = false
    var newsList = emptyList<News>()
    override suspend fun getNews(): List<News> {
        return if (!isException) newsList else throw ServerException()
    }
}

@ExperimentalCoroutinesApi
class NewsViewModelTest {
    private val repository = FakeNewRepository()

    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @Test
    fun `ui state switch Loaded when server return news`(): Unit = runTest {
        repository.newsList = listOf(
            News(id = 0, title = "Carousell", "85B fund","", 1532853058, 1),
            News(id = 1, title = "John", "candidate","", 1532939458, 2)
        )
        val testResults = mutableListOf<NewsScreenState>()
        val job = launch(coroutinesTestRule.testDispatcher) {
            NewsViewModel(repository).uiState.collect {
                testResults.add(it)
            }
        }
        job.cancel()

        assertTrue("state is not Loading", testResults[0] is NewsScreenState.Loading)
        assertTrue("state is not Loaded", testResults[1] is NewsScreenState.Loaded)
        assertEquals("The amount of news is wrong", 2, (testResults[1] as NewsScreenState.Loaded).newsList.size)
    }
}