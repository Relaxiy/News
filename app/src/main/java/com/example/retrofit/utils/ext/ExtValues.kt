package com.example.retrofit.utils.ext

import android.content.Context
import com.example.retrofit.RetrofitApplication
import com.example.retrofit.di.AppComponent

val Context.appComponent: AppComponent
    get() = when(this){
        is RetrofitApplication -> appComponent
        else -> this.applicationContext.appComponent
    }