package com.example.googlenewscursor.data.repository

import com.example.googlenewscursor.data.model.NewsResponse
import com.example.googlenewscursor.data.source.remote.NewsApiService
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiService: NewsApiService) {
    suspend fun getNews(tag: String): NewsResponse {
        return apiService.getNews(tag)
    }
}