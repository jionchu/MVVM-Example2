package com.example.mvvm2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm2.model.Movie

class MovieDetailViewModel : ViewModel() {
    val movie: MutableLiveData<Movie> = MutableLiveData()

    fun setInfo(movie: Movie){
        this.movie.value = movie
    }
}