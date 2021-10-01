package com.example.mvvm2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm2.R
import com.example.mvvm2.model.Movie

class MainRecyclerAdapter : RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {
    private val items: ArrayList<Movie> = arrayListOf()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setItem(movie: Movie) {
            itemView.findViewById<TextView>(R.id.movie_tv_title).text = movie.title
            itemView.findViewById<TextView>(R.id.movie_tv_rating).text = "평점: ${movie.rating}"
            Glide
                .with(itemView)
                .load(movie.image)
                .into(itemView.findViewById(R.id.movie_iv_poster))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<Movie>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}