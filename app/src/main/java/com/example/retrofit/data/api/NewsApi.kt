package com.example.retrofit.data.api

import com.example.retrofit.data.models.NewsResponse
import com.example.retrofit.utils.constants.Constants
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    @Headers("Content-Type: application/json")
    suspend fun getNews(
        @Query("q") query: String?,
        @Query("language") language: String?,
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("page") pageNumber: Int = 1,
        @Query("sources") sources: String = "LENTA",
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): NewsResponse
}