package com.example.mvvm2.ui.main

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm2.R
import com.example.mvvm2.ui.adapter.MainRecyclerAdapter
import com.example.mvvm2.databinding.ActivityMainBinding
import com.example.mvvm2.ui.detail.DetailActivity
import com.example.mvvm2.ui.history.HistoryActivity
import com.example.mvvm2.util.SharedPrefManager

/**
 * api doc = https://developers.naver.com/docs/search/movie/ \
 * **/
class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerAdapter: MainRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences =
            this.getSharedPreferences(getString(R.string.preference_key), MODE_PRIVATE)

        mainViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MainViewModel::class.java)
        recyclerAdapter = MainRecyclerAdapter {
            // 아이템 클릭시 아이템 객체 인텐트로 전송
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("movie", it)
            }
            this.startActivity(intent)
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this
        binding.mainRecyclerview.adapter = recyclerAdapter

        mainViewModel.toastMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        mainViewModel.searchMessage.observe(this) {
            val searchHistory = SharedPrefManager.getHistory(sharedPreferences)

            if (searchHistory.contains(it)) {
                searchHistory.remove(it)
            } else if (searchHistory.size == 5) {
                searchHistory.removeLast()
            }

            searchHistory.add(0, it)

            SharedPrefManager.storeHistory(searchHistory, sharedPreferences)
        }

        binding.mainBtnHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage(getString(R.string.search_loading))

        mainViewModel.isLoading.observe(this) {
            if (it) progressDialog.show()
            else progressDialog.hide()
        }

        // 검색 기록 클릭했을 때
        val keyword = intent.extras?.getString("history")
        keyword?.let { mainViewModel.searchMovie(keyword) }
    }
}