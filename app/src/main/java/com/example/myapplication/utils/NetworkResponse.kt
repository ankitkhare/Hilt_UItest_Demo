package com.example.myapplication.utils

import okhttp3.Request
import okhttp3.ResponseBody

sealed class NetworkResponse<out T> {
    data class Success<T>(
        val statusCode: Int,
        val value: T
    ) : NetworkResponse<T>()

    sealed class Failure : NetworkResponse<Nothing>() {
        data class Http(
            val statusCode: Int,
            val rawBody: ResponseBody?,
            val request: Request
        ) : Failure()

        data class IO(
            val exception: NetworkIOException,
        ) : Failure()

        data class Unknown(
            val exception: Throwable,
        ) : Failure()
    }
}


fun <T> NetworkResponse<T>.getOrNull(): T? = when (this) {
    is NetworkResponse.Success -> value
    is NetworkResponse.Failure -> null
}