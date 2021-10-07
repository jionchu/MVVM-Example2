package com.example.mvvm2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm2.R
import com.example.mvvm2.adapter.MainRecyclerAdapter
import com.example.mvvm2.databinding.ActivityMainBinding
import com.example.mvvm2.viewmodel.MovieListViewModel

/**
 * api doc = https://developers.naver.com/docs/search/movie/ \
 * **/
class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MovieListViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerAdapter: MainRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MovieListViewModel::class.java)
        recyclerAdapter = MainRecyclerAdapter()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this
        binding.mainRecyclerview.adapter = recyclerAdapter

        mainViewModel.toastMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}