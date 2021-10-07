package com.example.mvvm2.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mvvm2.model.Movie

class MovieDetailViewModel : ViewModel() {
    var movie: Movie = Movie("","","","","","","", "")

    fun setInfo(movie: Movie) {
        this.movie = movie
    }
}