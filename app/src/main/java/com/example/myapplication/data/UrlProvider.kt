package com.example.myapplication.data

import javax.inject.Inject

class DefaultUrlProvider @Inject constructor(): UrlProvider {
    override fun getUrl() = "https://jsonplaceholder.typicode.com"
}

interface UrlProvider {
    fun getUrl(): String
}