package com.example.myapplication.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostItem(
	@SerialName("id")
	val id: Int,
	@SerialName("title")
	val title: String,
	@SerialName("body")
	val body: String,
	@SerialName("userId")
	val userId: Int
)
