package com.example.mvvm2.util

import android.content.SharedPreferences
import com.google.gson.Gson

object SharedPrefManager {

    fun storeHistory(searchHistory: MutableList<String>, sharedPreferences: SharedPreferences) {
        // 문자열로 변환
        val searchHistoryString: String = Gson().toJson(searchHistory)

        with(sharedPreferences.edit()) {
            putString("history", searchHistoryString)
            commit()
        }
    }

    fun getHistory(sharedPreferences: SharedPreferences): MutableList<String> {
        val searchHistoryString = sharedPreferences.getString("history", null)

        return if (searchHistoryString != null)
            Gson().fromJson(searchHistoryString, Array<String>::class.java).toMutableList()
        else
            mutableListOf()
    }
}