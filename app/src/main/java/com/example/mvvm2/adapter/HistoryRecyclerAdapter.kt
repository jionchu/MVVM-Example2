package com.example.mvvm2.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm2.databinding.ItemHistoryBinding
import com.example.mvvm2.ui.MainActivity

class HistoryRecyclerAdapter : RecyclerView.Adapter<HistoryRecyclerAdapter.ViewHolder>() {
    private val items = mutableListOf<String>()

    class ViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setItem(history: String) {
            binding.history = history

            // 아이템 클릭시 아이템 객체 인텐트로 전송
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, MainActivity::class.java).apply {
                    putExtra("history", history)
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                }
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: MutableList<String>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}