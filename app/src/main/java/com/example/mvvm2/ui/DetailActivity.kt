package com.example.mvvm2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm2.R
import com.example.mvvm2.databinding.ActivityDetailBinding
import com.example.mvvm2.model.Movie
import com.example.mvvm2.viewmodel.MovieDetailViewModel

class DetailActivity : AppCompatActivity() {
    private lateinit var detailViewModel: MovieDetailViewModel
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        detailViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MovieDetailViewModel::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.viewModel = detailViewModel
        binding.lifecycleOwner = this

        val movie = intent.extras?.getParcelable<Movie>("movie")
        detailViewModel.setInfo(movie)
    }
}