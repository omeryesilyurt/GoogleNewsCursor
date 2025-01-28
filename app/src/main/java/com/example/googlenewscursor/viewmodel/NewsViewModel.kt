package com.example.googlenewscursor.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googlenewscursor.data.model.NewsResponse
import com.example.googlenewscursor.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {

    private val _newsResponse = MutableStateFlow<NewsResponse?>(null)
    val newsResponse: StateFlow<NewsResponse?> = _newsResponse

    fun fetchNews(tag: String) {
        viewModelScope.launch {
            _newsResponse.value = repository.getNews(tag)
        }
    }
} 