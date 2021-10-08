package com.example.mvvm2.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm2.model.Movie

@BindingAdapter("android:setItems")
fun setItems(view: View, items: ArrayList<Movie>?) {
    items?.run {
        (((view as? RecyclerView)?.adapter) as? MainRecyclerAdapter)?.setItems(this)
    }
}

@BindingAdapter("android:setHistoryItems")
fun setHistoryItems(view: View, items: MutableList<String>) {
    items?.run {
        ((view as? RecyclerView)?.adapter as? HistoryRecyclerAdapter)?.setItems(this)
    }
}

@BindingAdapter("android:imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String) {
    Glide
        .with(view.context)
        .load(imageUrl)
        .into(view)
}

@BindingAdapter("android:setRating")
fun setRating(view: TextView, rating: String) {
    view.text = "평점: $rating"
}