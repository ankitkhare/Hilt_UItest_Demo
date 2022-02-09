package com.example.myapplication.data.network

import com.example.myapplication.data.network.models.PostItem
import com.example.myapplication.utils.NetworkResponse
import retrofit2.http.GET

interface PlaceHolderApi {

    @GET("/posts")
    suspend fun postResponse(): NetworkResponse<List<PostItem>>
}