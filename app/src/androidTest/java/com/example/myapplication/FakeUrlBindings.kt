package com.example.myapplication

import com.example.myapplication.data.UrlProvider
import com.example.myapplication.di.UrlModuleBindings
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Named

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [UrlModuleBindings::class]
)
abstract class FakeUrlBindings {

    @Binds
    abstract fun getUrlProvider(defaultUrl: FakeUrlProvider): UrlProvider
}