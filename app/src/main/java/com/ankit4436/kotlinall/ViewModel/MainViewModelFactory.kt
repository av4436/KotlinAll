package com.ankit4436.kotlinall.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ankit4436.kotlinall.Repository.QuoteRepository

class MainViewModelFactory(private val quoteRepository: QuoteRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(quoteRepository) as T
    }
}