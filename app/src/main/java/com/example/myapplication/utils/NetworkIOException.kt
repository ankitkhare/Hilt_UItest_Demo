package com.example.myapplication.utils

import okhttp3.Request
import java.io.IOException

class NetworkIOException(cause: Throwable, val request: Request) : IOException(cause)