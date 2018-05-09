package com.example.daggerkotlinmvvm_myown.di.component

import android.app.Application
import android.content.Context
import android.os.Handler
import com.example.daggerkotlinmvvm_myown.di.builder.ActivityBuilder
import com.example.daggerkotlinmvvm_myown.di.modules.*
import com.squareup.picasso.Picasso
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton
import dagger.BindsInstance
import com.example.daggerkotlinmvvm_myown.App
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector


/**
 * Created by Dima on 06.05.2018.
 */

@Component(modules = arrayOf(AndroidInjectionModule::class,
        NetworkModule::class,
        ContextModule::class,
        DownloadImageModule::class,
        HandlerModule::class,
        ActivityBuilder::class))
@Singleton
interface AppComponent {

    fun inject(app: App)

//    fun getAppContext(): Context
//    fun getRetrofit(): Retrofit
//    fun getPicasso(): Picasso
//    fun getHandler(): Handler
}