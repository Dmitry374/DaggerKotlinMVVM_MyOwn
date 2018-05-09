package com.example.daggerkotlinmvvm_myown

import android.app.Activity
import android.app.Application
import android.content.Context
import com.example.daggerkotlinmvvm_myown.di.component.DaggerAppComponent
import com.example.daggerkotlinmvvm_myown.di.modules.ContextModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


/**
 * Created by Dima on 06.05.2018.
 */
class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

//    companion object {
//        lateinit var appComponent: AppComponent
//    }

    private lateinit var mContext: Context

    override fun onCreate() {
        super.onCreate()
        mContext = applicationContext
//        appComponent = DaggerAppComponent.builder()
//                .contextModule(ContextModule(mContext))
//                .networkModule(NetworkModule("http://keit126.ru/"))
//                .build()

        DaggerAppComponent.builder()
                .contextModule(ContextModule(mContext))
                .build()
                .inject(this)

    }

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

}