package com.example.retrofit.di

import com.example.retrofit.data.NewsRepositoryImpl
import com.example.retrofit.domain.interactor.NewsInteractor
import com.example.retrofit.domain.interactor.NewsInteractorImpl
import com.example.retrofit.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module

@Module
interface BindRepositoriesModule {

    @Binds
    fun bindNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository
}