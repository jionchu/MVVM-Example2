package com.example.mvvm2.viewmodel

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm2.R
import com.example.mvvm2.api.Api
import com.example.mvvm2.model.Movie
import com.example.mvvm2.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListViewModel : ViewModel() {
    val movieList: MutableLiveData<ArrayList<Movie>> = MutableLiveData()
    var toastMessage: MutableLiveData<String> = MutableLiveData()

    fun searchMovie(query: String) {

        if (query.isBlank()) {
            toastMessage.value = "검색할 제목을 입력해주세요."
            return
        }

        Api.searchApi.searchMovie(query).enqueue(object : Callback<SearchResponse> {
            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                val searchResponse = response.body()
                movieList.value = searchResponse?.movies
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                toastMessage.value = "영화 검색에 실패했습니다."
            }
        })
    }
}