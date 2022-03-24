package com.example.retrofit.domain.interactor

import com.example.retrofit.domain.models.BaseItem

interface NewsInteractor {

    suspend fun getNews(search: String): Map<String, List<BaseItem>>
}