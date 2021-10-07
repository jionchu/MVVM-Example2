package com.example.mvvm2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm2.api.Api
import com.example.mvvm2.model.Movie
import com.example.mvvm2.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListViewModel : ViewModel() {
    val movieList: MutableLiveData<ArrayList<Movie>> = MutableLiveData()

    fun searchMovie(query: String) {

        Api.searchApi.searchMovie(query).enqueue(object : Callback<SearchResponse> {
            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                val searchResponse = response.body()
                movieList.value = searchResponse?.movies
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                println("request fail")
            }
        })
    }
}