package com.example.androidexample.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidexample.remote.NewsRepository
import com.example.androidexample.remote.dao.News
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class NewsScreenState {
    object Loading: NewsScreenState()
    class Loaded(val newsList: List<News>, val sort: Sort): NewsScreenState()
    object Failure: NewsScreenState()
}

enum class Sort { RECENT, POPULAR }

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository,
): ViewModel() {
    private val _uiState = MutableStateFlow<NewsScreenState>(NewsScreenState.Loading)
    val uiState: StateFlow<NewsScreenState> = _uiState

    init {
        alignment(Sort.RECENT)
    }

    fun alignment(sort: Sort) {
        viewModelScope.launch {
            _uiState.value = try {
                NewsScreenState.Loaded(
                    repository.getNews()
                        .run {
                            when (sort) {
                                Sort.RECENT -> sortedByDescending { it.created }
//                                    .onEach {
//                                        Log.d(
//                                            "John",
//                                            "sort by recent:${Instant.fromEpochSeconds(it.created.toLong())}"
//                                        )
//                                    }
                                Sort.POPULAR -> sortedWith(compareBy<News> { it.rank }.thenBy { -it.created })
//                                    .onEach {
//                                        Log.d(
//                                            "John",
//                                            "sort by popular:${it.rank} && ${it.created}"
//                                        )
//                                    }
                            }
                        },
                    sort
                )
            } catch (e: Exception) {
                NewsScreenState.Failure
            }
        }
    }
}