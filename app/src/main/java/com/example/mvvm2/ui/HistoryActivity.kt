package com.example.mvvm2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm2.R
import com.example.mvvm2.adapter.HistoryRecyclerAdapter
import com.example.mvvm2.databinding.ActivityHistoryBinding
import com.example.mvvm2.util.SharedPrefManager
import com.example.mvvm2.viewmodel.HistoryListViewModel

class HistoryActivity : AppCompatActivity() {
    private lateinit var historyViewModel: HistoryListViewModel
    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val sharedPreferences =
            this.getSharedPreferences(getString(R.string.preference_key), MODE_PRIVATE)

        historyViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(HistoryListViewModel::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_history)
        binding.viewModel = historyViewModel
        binding.lifecycleOwner = this
        binding.historyRecyclerview.adapter = HistoryRecyclerAdapter {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("history", it)
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            }
            this.startActivity(intent)
        }

        val history: MutableList<String> = SharedPrefManager.getHistory(sharedPreferences)
        historyViewModel.setItems(history)
    }
}