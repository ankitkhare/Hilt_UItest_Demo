package com.example.myapplication.di

import com.example.myapplication.domain.ApiManager
import com.example.myapplication.domain.DefaultApiManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(
    includes = [UrlModuleBindings::class, NetworkModule::class]
)
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiHelper(apiManager: DefaultApiManager): ApiManager = apiManager
}