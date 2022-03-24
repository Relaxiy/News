package com.example.retrofit.utils.ext

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.retrofit.data.models.ArticleResponse
import com.example.retrofit.domain.models.BaseItem
import com.example.retrofit.domain.models.Date
import com.example.retrofit.domain.models.News

fun FragmentActivity.openFragment(tag: String, fragment: Fragment, id: Int) {
    supportFragmentManager
        .beginTransaction()
        .replace(id, fragment, tag)
        .addToBackStack(tag)
        .commit()
}

fun String.toDate(): String {
    return this.substring(0, 10)
}

fun List<ArticleResponse>.toBaseItems(): List<BaseItem> {
    val items = mutableListOf<BaseItem>()
    this.forEachIndexed { index, item ->
        if (index == 0) {
            items.add(
                Date(item.publishedAt.toDate())
            )
        } else if (item.publishedAt.toDate() != this[index - 1].publishedAt.toDate()) {
            items.add(
                Date(item.publishedAt.toDate())
            )
        }
        items.add(
            News(
                author = item.author,
                title = item.title,
                description = item.description,
                url = item.url,
                urlToImage = item.urlToImage,
                content = item.content,
                idNewsChannel = item.source.idNewsChannel,
                nameNewsChannel = item.source.nameNewsChannel
            )
        )
    }
    return items
}