package com.example.myapplication.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.network.models.PostItem
import com.example.myapplication.domain.ApiManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val apiManager: ApiManager) : ViewModel() {

    private val postData = MutableLiveData<List<PostItem>>()

    fun getPostLiveData(): LiveData<List<PostItem>> = postData

    fun getAllPost() {
        viewModelScope.launch {
            apiManager.getAllPost()?.let {
                postData.postValue(it)
            }
        }
    }
}