package com.example.googlenewscursor.data.source.remote

import com.example.googlenewscursor.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApiService {
    @GET("getNews?country=tr")
    suspend fun getNews(
        @Query("tag") tag: String,
        @Query("paging") paging: Int = 0,
    ): NewsResponse
} 