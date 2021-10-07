package com.example.mvvm2.api

import com.example.mvvm2.XHeaderInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Api {
    private const val BASE_URL = "https://openapi.naver.com/v1/search/"

    private val client = OkHttpClient.Builder()
        .readTimeout(5000, TimeUnit.MILLISECONDS)
        .connectTimeout(5000, TimeUnit.MILLISECONDS)
        .addNetworkInterceptor(XHeaderInterceptor()) // 자동 헤더 전송
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val searchApi: SearchService = retrofit.create(SearchService::class.java)
}