package com.example.mvvm2.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm2.data.model.Movie

class DetailViewModel : ViewModel() {
    val movie: MutableLiveData<Movie> = MutableLiveData()

    fun setInfo(movie: Movie){
        this.movie.value = movie
    }
}