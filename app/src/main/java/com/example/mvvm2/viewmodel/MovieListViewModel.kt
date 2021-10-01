package com.example.mvvm2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm2.MyApplication
import com.example.mvvm2.api.SearchService
import com.example.mvvm2.model.Movie
import com.example.mvvm2.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListViewModel : ViewModel() {
    private var movieList: MutableLiveData<List<Movie>> = MutableLiveData()

    fun searchMovie(query: String) {
        val searchService = MyApplication.retrofit.create(SearchService::class.java)
        searchService.searchMovie(query).enqueue(object : Callback<SearchResponse> {
            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                val searchResponse = response.body()
                movieList.value = searchResponse!!.movies
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                println("request fail")
            }
        })
    }
}