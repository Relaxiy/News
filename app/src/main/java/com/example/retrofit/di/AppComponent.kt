package com.example.retrofit.di

import com.example.retrofit.presentation.fragments.NewsListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RetrofitModule::class,
        BindRepositoriesModule::class,
        BindInteractorsModule::class
    ]
)
interface AppComponent {

    //Fragments
    fun inject(newsListFragment: NewsListFragment)

}