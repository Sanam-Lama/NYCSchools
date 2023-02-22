package com.example.nycschool.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschool.models.SatResults
import com.example.nycschool.repository.SatResultRepository
import kotlinx.coroutines.launch

class ResultViewModel(private val satResultRepository: SatResultRepository): ViewModel() {

    val satResults: LiveData<SatResults>
        get() = satResultRepository.satResultLiveData

    fun getSatResults() {
        viewModelScope.launch {
            satResultRepository.getSatResults()
        }
    }
}