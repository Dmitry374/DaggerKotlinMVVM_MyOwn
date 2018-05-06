package com.example.daggerkotlinmvvm_myown.di.modules

import android.os.Handler
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Dima on 06.05.2018.
 */

@Module
class HandlerModule {
    @Singleton
    @Provides
    fun handler(): Handler {
        return Handler()
    }
}