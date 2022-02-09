package com.example.myapplication.domain

import com.example.myapplication.data.network.PlaceHolderApi
import com.example.myapplication.data.network.models.PostItem
import com.example.myapplication.utils.getOrNull
import javax.inject.Inject

interface ApiManager {

    suspend fun getAllPost(): List<PostItem>?
}

class DefaultApiManager @Inject constructor(private val api: PlaceHolderApi) : ApiManager {

    override suspend fun getAllPost(): List<PostItem>? {
        return api.postResponse().getOrNull()
    }
}