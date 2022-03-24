package com.example.retrofit.presentation.recycler.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.retrofit.R
import com.example.retrofit.domain.models.BaseItem
import com.example.retrofit.domain.models.Date
import com.example.retrofit.presentation.recycler.BaseViewHolder

class DateViewHolder(itemView: View) : BaseViewHolder(itemView) {
    companion object{
        const val VIEW_TYPE = 1
        fun newInstance(parent: ViewGroup) = DateViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.date_item,
                parent,
                false
            )
        )
    }

    private val inputDate by lazy {
        itemView.findViewById<TextView>(R.id.date)
    }
    override fun bindItem(baseItem: BaseItem) {
        (baseItem as Date).apply {
            inputDate.text = newsDate
        }
    }
}