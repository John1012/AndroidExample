package com.example.androidexample.utils

sealed class RequestState<out T> {
    object Idle: RequestState<Nothing>()
    object Loading: RequestState<Nothing>()
    data class Success<T>(val data: T): RequestState<T>()
    data class Failure<T>(val error: Throwable): RequestState<T>()
}
