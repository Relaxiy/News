package com.example.retrofit.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.presentation.recycler.BaseAdapter
import com.example.retrofit.presentation.viewModels.NewsListFragmentViewModel
import com.example.retrofit.utils.ext.appComponent
import kotlinx.android.synthetic.main.fragment_news_list.*
import javax.inject.Inject

class NewsListFragment : Fragment(R.layout.fragment_news_list) {
    companion object {
        const val TAG = "NewsListFragment"
        fun newInstance() = NewsListFragment()
    }

    @Inject
    lateinit var newsListFragmentViewModel: NewsListFragmentViewModel

    private val recycler by lazy {
        view?.findViewById<RecyclerView>(R.id.newsRecycler)
    }

    private val adapter by lazy {
        BaseAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().appComponent.inject(this)
        loadNews()
    }

    private fun loadNews() {
        newsListFragmentViewModel.loadNews("")
        recycler?.adapter = adapter
        newsListFragmentViewModel.items.observe(viewLifecycleOwner) { baseItems ->
            totalResults.text = baseItems.keys.first()
            adapter.setItems(baseItems.values.first())
        }
    }

}