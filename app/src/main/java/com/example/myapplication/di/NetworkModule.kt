package com.example.myapplication.di

import androidx.viewbinding.BuildConfig
import com.example.myapplication.data.UrlProvider
import com.example.myapplication.data.network.NetworkResponseCallAdapterFactory
import com.example.myapplication.data.network.PlaceHolderApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        urlProvider: UrlProvider,
        json: Json
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(urlProvider.getUrl())
            .client(okHttpClient)
            .addCallAdapterFactory(NetworkResponseCallAdapterFactory)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(PlaceHolderApi::class.java)

    @Singleton
    @Provides
    fun kotlinJsonSerializer(): Json {
        return Json {
            coerceInputValues = true
            ignoreUnknownKeys = true
        }
    }
}