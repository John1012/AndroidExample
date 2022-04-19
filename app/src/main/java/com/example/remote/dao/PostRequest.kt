package com.example.remote.dao

import kotlinx.serialization.Serializable

@Serializable
data class PostRequest(
    val body: String,
    val title: String,
    val id: String,
    val userId: String
)
