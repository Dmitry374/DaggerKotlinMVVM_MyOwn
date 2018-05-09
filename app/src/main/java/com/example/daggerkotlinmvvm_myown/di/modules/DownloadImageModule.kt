package com.example.daggerkotlinmvvm_myown.di.modules

import android.content.Context
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Dima on 06.05.2018.
 */

@Module(includes = arrayOf(ContextModule::class))
class DownloadImageModule {
    @Singleton
    @Provides
    fun picasso(context: Context): Picasso {
        return Picasso.Builder(context)
                .build()
    }
}