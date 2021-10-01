package com.example.mvvm2.adapter

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm2.model.Movie

@BindingAdapter("android:setItems")
fun setItems(view: View, items: List<Movie>?) {
    items?.run {
        ((view as RecyclerView).adapter as MainRecyclerAdapter).setItems(this)
    }
}