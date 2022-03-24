package com.example.retrofit.presentation.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.domain.models.BaseItem

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bindItem(baseItem: BaseItem)
}