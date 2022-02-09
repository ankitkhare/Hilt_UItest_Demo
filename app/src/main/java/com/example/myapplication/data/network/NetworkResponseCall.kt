package com.example.myapplication.data.network

import com.example.myapplication.utils.NetworkIOException
import com.example.myapplication.utils.NetworkResponse
import okhttp3.Request
import okio.IOException
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal class NetworkResponseCall(
    private val delegate: Call<Any?>,
    private val successMapper: (Response<Any?>) -> NetworkResponse<Any?>,
) : Call<NetworkResponse<Any?>> {
    // This is wanted. Exceptions should be wrapped in Result class in order to preserve referential transparency.
    @Suppress("TooGenericExceptionCaught")
    override fun execute(): Response<NetworkResponse<Any?>> {
        val result = try {
            delegate.execute().toResult()
        } catch (e: IOException) {
            NetworkResponse.Failure.IO(NetworkIOException(e, delegate.request()))
        } catch (e: Throwable) {
            NetworkResponse.Failure.Unknown(e)
        }
        return Response.success(result)
    }

    override fun enqueue(callback: Callback<NetworkResponse<Any?>>) = delegate.enqueue(object : Callback<Any?> {
        override fun onResponse(call: Call<Any?>, response: Response<Any?>) {
            val result = response.toResult()
            callback.onResponse(this@NetworkResponseCall, Response.success(result))
        }

        override fun onFailure(call: Call<Any?>, throwable: Throwable) {
            val failure = when (throwable) {
                is IOException -> NetworkResponse.Failure.IO(NetworkIOException(throwable, call.request()))
                else -> NetworkResponse.Failure.Unknown(throwable)
            }

            callback.onResponse(
                this@NetworkResponseCall,
                Response.success(failure)
            )
        }
    })

    private fun Response<Any?>.toResult() = if (isSuccessful) {
        successMapper(this)
    } else {
        NetworkResponse.Failure.Http(code(), errorBody(), request())
    }

    override fun request(): Request = delegate.request()

    override fun clone() = NetworkResponseCall(delegate.clone(), successMapper)

    override fun isExecuted() = delegate.isExecuted

    override fun isCanceled() = delegate.isCanceled

    override fun cancel() = delegate.cancel()

    override fun timeout(): Timeout = delegate.timeout()
}