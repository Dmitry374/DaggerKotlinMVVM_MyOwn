package com.example.daggerkotlinmvvm_myown.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by Dima on 06.05.2018.
 */

@Module
class ContextModule(private val appContext: Context) {

    @Provides
    fun appContext(): Context = appContext;
}