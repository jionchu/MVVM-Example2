package com.example.mvvm2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm2.data.api.Api
import com.example.mvvm2.data.model.Movie
import com.example.mvvm2.data.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val movieList: MutableLiveData<ArrayList<Movie>> = MutableLiveData()
    val toastMessage: MutableLiveData<String> = MutableLiveData()
    val searchMessage: MutableLiveData<String> = MutableLiveData()
    val tvVisibility: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun searchMovie(query: String) {

        if (query.isBlank()) {
            toastMessage.value = "검색할 제목을 입력해주세요."
            return
        }

        searchMessage.value = query
        isLoading.value = true
        Api.searchApi.searchMovie(query).enqueue(object : Callback<SearchResponse> {
            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                val searchResponse = response.body()
                movieList.value = searchResponse?.movies

                tvVisibility.value = movieList.value?.size == 0
                isLoading.value = false
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                toastMessage.value = "영화 검색에 실패했습니다."
                tvVisibility.value = true
                isLoading.value = false
            }
        })
    }
}