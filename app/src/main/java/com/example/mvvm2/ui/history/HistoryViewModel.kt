package com.example.mvvm2.ui.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HistoryViewModel : ViewModel() {

    val historyList: MutableLiveData<MutableList<String>> = MutableLiveData()
    val tvVisibility: MutableLiveData<Boolean> = MutableLiveData()

    fun setItems(historyList: MutableList<String>) {
        this.historyList.value = historyList

        tvVisibility.value = historyList.size == 0
    }
}