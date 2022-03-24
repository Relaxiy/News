package com.example.retrofit.domain.repository

import com.example.retrofit.data.models.NewsResponse

interface NewsRepository {

    suspend fun getNewsResponse(search: String): NewsResponse
}