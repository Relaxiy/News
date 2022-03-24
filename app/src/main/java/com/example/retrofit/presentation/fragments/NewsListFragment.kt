package com.example.retrofit.presentation.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.presentation.recycler.BaseAdapter
import com.example.retrofit.presentation.recycler.clickListeners.ShareClickListener
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
        BaseAdapter(shareNews)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().appComponent.inject(this)
        loadNews()
    }

    private val shareNews by lazy {
        object : ShareClickListener {
            override fun sendNews(newsLink: String) {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    data = Uri.parse("mailto:")
                    type = "text/plain"
                    putExtra(Intent.EXTRA_SUBJECT, "News")
                    putExtra(Intent.EXTRA_TEXT, newsLink)
                }
                startActivity(Intent.createChooser(intent, "Choose Email Client"))
            }
        }
    }

    private fun loadNews() {
        search.setOnEditorActionListener(TextView.OnEditorActionListener{ _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                newsListFragmentViewModel.loadNews(search.text.toString())
                recycler?.adapter = adapter
                newsListFragmentViewModel.items.observe(viewLifecycleOwner) { baseItems ->
                    totalResults.text = baseItems.keys.first()
                    adapter.setItems(baseItems.values.first())
                }
                return@OnEditorActionListener true
            }
            false
        })
    }

}