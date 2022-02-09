package com.example.myapplication.data.network

import com.example.myapplication.utils.NetworkResponse
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Response
import java.lang.reflect.Type

internal class NetworkResponseAdapter(
    private val type: Type,
) : CallAdapter<Any?, Call<NetworkResponse<Any?>>> {
    private val voidMapper = { response: Response<Any?> ->
        NetworkResponse.Success(response.code(), null)
    }

    private val unitMapper = { response: Response<Any?> ->
        NetworkResponse.Success(response.code(), Unit)
    }

    private val typeMapper = { response: Response<Any?> ->
        val body = response.body()
        if (body == null) {
            // This unfortunate behaviour is result of https://github.com/square/retrofit/issues/3075
            val unexpectedNullBodyException = IllegalArgumentException(
                "Unexpected null response. Parametrize NetworkResponse with Void or Unit instead."
            )
            NetworkResponse.Failure.Unknown(unexpectedNullBodyException)
        } else {
            NetworkResponse.Success(
                response.code(),
                body
            )
        }
    }

    private val successMapper: (Response<Any?>) -> NetworkResponse<Any?> = when (type) {
        Void::class.java -> voidMapper
        Unit::class.java -> unitMapper
        else -> typeMapper
    }

    override fun responseType() = type

    override fun adapt(call: Call<Any?>) = NetworkResponseCall(call, successMapper)
}
