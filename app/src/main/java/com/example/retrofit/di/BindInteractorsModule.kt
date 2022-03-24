package com.example.retrofit.di

import com.example.retrofit.domain.interactor.NewsInteractor
import com.example.retrofit.domain.interactor.NewsInteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface BindInteractorsModule {

    @Binds
    fun bindNewsInteractor(newsInteractorImpl: NewsInteractorImpl): NewsInteractor
}