package com.example.myapplication

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class SuccessDispatchers : Dispatcher() {

    override fun dispatch(request: RecordedRequest): MockResponse {
        return if (request.path.orEmpty().contains("posts"))
            MockResponse().setResponseCode(200).setBody(MOCK_RESPONSE)
        else MockResponse().setResponseCode(200).setBody(MOCK_RESPONSE)
    }
}