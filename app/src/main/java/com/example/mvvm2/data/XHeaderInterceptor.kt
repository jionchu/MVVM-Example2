package com.example.mvvm2.data

import okhttp3.Interceptor
import okhttp3.Response

class XHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()

        builder.addHeader("X-Naver-Client-Id", "KPs1Fz7hGzcZRPFvViN7")
        builder.addHeader("X-Naver-Client-Secret", "qm06FtUOJ8")

        return chain.proceed(builder.build())
    }
}