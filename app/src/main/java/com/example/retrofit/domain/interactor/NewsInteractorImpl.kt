package com.example.retrofit.domain.interactor

import com.example.retrofit.data.models.NewsResponse
import com.example.retrofit.domain.models.BaseItem
import com.example.retrofit.domain.repository.NewsRepository
import com.example.retrofit.utils.ext.toBaseItems
import javax.inject.Inject

class NewsInteractorImpl @Inject constructor(private val newsRepository: NewsRepository) :
    NewsInteractor {
    override suspend fun getNews(search: String): Map<String, List<BaseItem>> {
        val response: NewsResponse = newsRepository.getNewsResponse(search)
        val result = mutableMapOf<String, List<BaseItem>>()
        result[response.totalResults] = response.articles.toBaseItems()
        return result.toMap()
    }


}