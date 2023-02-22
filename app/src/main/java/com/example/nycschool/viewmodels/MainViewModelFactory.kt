package com.example.nycschool.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nycschool.repository.SchoolRepository

/**
 * Whenever we have a parameterized ViewModel, we need to create a ViewModelFactory
 */
class MainViewModelFactory(private val repository: SchoolRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}