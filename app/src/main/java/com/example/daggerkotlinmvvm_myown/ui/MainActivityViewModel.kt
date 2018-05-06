package com.example.daggerkotlinmvvm_myown.ui

import com.example.daggerkotlinmvvm_myown.App
import com.example.mvvm_mytestgrechkakotlin_3.model.Model
import com.example.mvvm_mytestgrechkakotlin_3.model.ServerApi
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * Created by Dima on 06.05.2018.
 */
class MainActivityViewModel {

//    val serverApi by lazy {
//        ServerApi.create()
//    }

    @Inject
    lateinit var retrofit: Retrofit

    fun getObject(): Observable<Model.ItemServerData> {

//        retrofit = App.appComponent.getRetrofit()

        return retrofit.create(ServerApi::class.java).loadData()

//        return serverApi.loadData()
        /*.map {
            Model.ItemServerData(it.splashUrl)
        }*/
//                .onErrorReturn {
//                    null
//                }
    }
}