package com.example.retrofit.presentation.recycler.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.retrofit.R
import com.example.retrofit.domain.models.BaseItem
import com.example.retrofit.domain.models.News
import com.example.retrofit.presentation.recycler.BaseViewHolder

class NewsViewHolder(itemView: View) : BaseViewHolder(itemView) {

    companion object {
        const val VIEW_TYPE = 2
        fun newInstance(parent: ViewGroup) = NewsViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.news_item,
                parent,
                false
            )
        )
    }

    private val newsImage by lazy {
        itemView.findViewById<ImageView>(R.id.news_image)
    }

    private val newsTitle by lazy {
        itemView.findViewById<TextView>(R.id.news_title)
    }

    private val newsDescription by lazy {
        itemView.findViewById<TextView>(R.id.news_description)
    }

    private val newsAuthor by lazy {
        itemView.findViewById<TextView>(R.id.news_author)
    }

    private val share by lazy {
        itemView.findViewById<ImageView>(R.id.share)
    }

    override fun bindItem(baseItem: BaseItem) {
        (baseItem as News).apply {
            newsTitle.text = title
            newsDescription.text = description
            newsAuthor.text = author
            Glide.with(itemView.context).load(urlToImage).into(newsImage)
        }
        share.setOnClickListener {

        }
    }
}