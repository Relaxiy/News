package com.example.retrofit.data

import com.example.retrofit.data.api.NewsApi
import com.example.retrofit.data.models.NewsResponse
import com.example.retrofit.domain.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val newsApi: NewsApi): NewsRepository {
    override suspend fun getNewsResponse(search: String): NewsResponse {
        return withContext(Dispatchers.IO) {
            return@withContext newsApi.getNews(
                query = search,
                fromDate = null,
                toDate = null,
                language = "ru"
            )
        }
    }


}