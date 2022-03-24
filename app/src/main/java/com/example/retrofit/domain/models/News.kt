package com.example.retrofit.domain.models


data class News(
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val content: String,
    val idNewsChannel: String?,
    val nameNewsChannel: String
) : BaseItem()