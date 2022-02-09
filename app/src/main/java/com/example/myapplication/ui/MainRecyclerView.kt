package com.example.myapplication.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.network.models.PostItem
import com.example.myapplication.databinding.MainItemBinding

class MainRecyclerView(private val listData: List<PostItem>) :
    RecyclerView.Adapter<MainRecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listData[position])
    }

    override fun getItemCount(): Int = listData.size

    class ViewHolder(private val binding: MainItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: PostItem) {
            binding.id.text = item.id.toString()
            binding.title.text = item.title
            binding.body.text = item.body
        }
    }
}