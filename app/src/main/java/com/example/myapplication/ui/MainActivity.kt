package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        mainViewModel.getAllPost()
        binding.recycler.setHasFixedSize(true);
        binding.recycler.layoutManager = LinearLayoutManager(this)
        mainViewModel.getPostLiveData().observe(this) {
            val adapter = MainRecyclerView(it)
            binding.recycler.adapter = adapter
        }
    }
}