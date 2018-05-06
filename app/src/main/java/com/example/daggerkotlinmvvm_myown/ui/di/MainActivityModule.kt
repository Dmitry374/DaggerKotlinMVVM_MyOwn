package com.example.daggerkotlinmvvm_myown.ui.di

import com.example.daggerkotlinmvvm_myown.ui.MainActivityViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Dima on 06.05.2018.
 */

@Module
class MainActivityModule {
    @Provides
    fun provideViewModel() = MainActivityViewModel()
}