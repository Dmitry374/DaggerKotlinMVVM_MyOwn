package com.example.daggerkotlinmvvm_myown

import android.app.Application
import android.content.Context
import com.example.daggerkotlinmvvm_myown.di.component.AppComponent
import com.example.daggerkotlinmvvm_myown.di.component.DaggerAppComponent
import com.example.daggerkotlinmvvm_myown.di.modules.ContextModule
import com.example.daggerkotlinmvvm_myown.di.modules.NetworkModule

/**
 * Created by Dima on 06.05.2018.
 */
class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    private lateinit var mContext: Context

    override fun onCreate() {
        super.onCreate()
        mContext = applicationContext
        appComponent = DaggerAppComponent.builder()
                .contextModule(ContextModule(mContext))
                .networkModule(NetworkModule("http://keit126.ru/"))
                .build()
    }

}