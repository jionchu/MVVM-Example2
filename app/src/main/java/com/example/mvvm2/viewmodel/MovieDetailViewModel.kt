package com.example.mvvm2.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mvvm2.model.Movie

class MovieDetailViewModel : ViewModel() {
    lateinit var movie: Movie

    fun setInfo(movie: Movie?) {
        if (movie != null) {
            this.movie = movie
        }
    }
}