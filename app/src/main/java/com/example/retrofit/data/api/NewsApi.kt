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
        @Query("from") fromDate: String?,
        @Query("to") toDate: String?,
        @Query("language") language: String?,
        @Query("sortBy") sortBy: String = "relevancy",
        @Query("page") pageNumber: Int = 1,
        @Query("sources") sources: String = "RBC",
        @Query("pageSize") pageSize: Int = 20,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): NewsResponse
}