package com.example.nycschool.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nycschool.api.SatResultService
import com.example.nycschool.models.SatResults

/**
 * I created this repository to continue for the second api call
 */
class SatResultRepository(private val satResultService: SatResultService) {

    private val _satResultLiveData = MutableLiveData<SatResults>()
    val satResultLiveData: LiveData<SatResults>
    get() = _satResultLiveData

    suspend fun getSatResults() {
        val result = satResultService.getSatResults()
        if (result?.body() != null) {
            _satResultLiveData.postValue(result.body())
        }
    }
}