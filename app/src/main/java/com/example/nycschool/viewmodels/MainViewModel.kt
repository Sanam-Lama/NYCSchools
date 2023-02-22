package com.example.nycschool.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschool.repository.SchoolRepository
import kotlinx.coroutines.launch

/**
 * MainViewModel class here is added to communicate between the data and the model that we have
 * added separately in the project. This class will make a call to repository and from there we
 * get the observed data and is sent to the view.
 */
class MainViewModel(private val schoolRepository: SchoolRepository): ViewModel() {

    val schoolData: LiveData<String>
        get() = schoolRepository.schoolLiveData

    fun getSchools() {
        viewModelScope.launch {
            schoolRepository.getSchools()
        }
    }
}