package com.example.retrofit.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.domain.interactor.NewsInteractor
import com.example.retrofit.domain.models.BaseItem
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class NewsListFragmentViewModel @Inject constructor(private val newsInteractor: NewsInteractor) :
    ViewModel() {

    val items: LiveData<Map<String, List<BaseItem>>> get() = _items
    private val _items = MutableLiveData<Map<String, List<BaseItem>>>()

    fun loadNews(search: String) {
        viewModelScope.launch {
            try {
                viewModelScope.launch {
                    _items.postValue(newsInteractor.getNews(search))
                }.join()
            } catch (e: Exception) {
                Log.e("News", e.localizedMessage)
            }
        }
    }
}