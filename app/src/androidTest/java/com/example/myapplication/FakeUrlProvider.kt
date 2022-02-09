package com.example.myapplication

import com.example.myapplication.data.UrlProvider
import javax.inject.Inject

class FakeUrlProvider @Inject constructor() : UrlProvider {
    override fun getUrl(): String = "http://localhost:8080"
}