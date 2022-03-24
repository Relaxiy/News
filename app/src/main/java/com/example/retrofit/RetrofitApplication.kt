package com.example.retrofit

import android.app.Application
import com.example.retrofit.di.AppComponent
import com.example.retrofit.di.DaggerAppComponent

class RetrofitApplication : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()
    }
}