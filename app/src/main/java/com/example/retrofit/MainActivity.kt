package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofit.presentation.fragments.NewsListFragment
import com.example.retrofit.utils.ext.openFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        openFragment(NewsListFragment.TAG, NewsListFragment.newInstance(), R.id.container)
    }
}