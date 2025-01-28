package com.example.googlenewscursor.data.model

data class NewsResponse(
    val success: Boolean,
    val result: List<NewsItem>
)

data class NewsItem(
    val title: String?,
    val description: String,
    val image: String,
    val url: String,
    val publishedAt: String
) 