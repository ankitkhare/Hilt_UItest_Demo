package com.example.myapplication.di

import com.example.myapplication.data.DefaultUrlProvider
import com.example.myapplication.data.UrlProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class UrlModuleBindings {

    @Binds
    abstract fun getUrlProvider(defaultUrl: DefaultUrlProvider): UrlProvider
}