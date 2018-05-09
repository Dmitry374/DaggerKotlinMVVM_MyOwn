package com.example.daggerkotlinmvvm_myown.di.builder

import com.example.daggerkotlinmvvm_myown.ui.MainActivity
import com.example.daggerkotlinmvvm_myown.ui.di.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Dima on 06.05.2018.
 */

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity
}