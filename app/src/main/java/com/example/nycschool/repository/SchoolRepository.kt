package com.example.nycschool.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nycschool.api.SchoolService
import com.example.nycschool.models.School
import com.example.nycschool.models.SchoolItem

/**
 * This is the repository class for this project where we add the methods for network calls.
 * We make use of LiveData and MutableLiveData to help us observe the actual data that is
 * coming from the network.
 *
 * ViewModel will call the methods in here and get the required data from the call
 */

class SchoolRepository(private val schoolService: SchoolService) {

    private val _schoolLiveData = MutableLiveData<String>()

    val schoolLiveData: LiveData<String>
        get() = _schoolLiveData

    suspend fun getSchools() {
        val result = schoolService.getSchools()
        if (result?.body() != null) {
            _schoolLiveData.postValue(result.body().toString())
        }
    }
}