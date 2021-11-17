package com.example.mvvm2.data.api

import com.example.mvvm2.data.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET("movie.json")
    fun searchMovie(
        @Query("query") query: String
    ): Call<SearchResponse>
}