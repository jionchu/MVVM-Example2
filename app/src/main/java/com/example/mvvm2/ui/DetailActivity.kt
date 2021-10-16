package com.example.mvvm2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

        // movie가 null인 경우 초기화 -> databinding null 오류 방지
        detailViewModel.setInfo(movie ?: Movie("", "", "", "", "", "", "", ""))
        // movie가 null인 경우 메시지 띄우기
        movie ?: Toast.makeText(this, getString(R.string.detail_fail), Toast.LENGTH_SHORT).show()
    }
}