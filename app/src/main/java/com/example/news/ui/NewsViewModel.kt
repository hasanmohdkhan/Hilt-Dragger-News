package com.example.news.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.network.NewsApi
import com.example.news.repository.Repository
import kotlinx.coroutines.launch

class NewsViewModel
@ViewModelInject
constructor(
        private val repository: Repository
) : ViewModel() {

    fun get() {
        viewModelScope.launch {
            repository.get()
        }
    }

}