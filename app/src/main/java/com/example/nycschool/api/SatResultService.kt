package com.example.nycschool.api

import com.example.nycschool.models.SatResults
import retrofit2.Response
import retrofit2.http.GET

/**
 * I created this class to continue the second part and display few items
 */
interface SatResultService {

    @GET("resource/f9bf-2cp4")
    fun getSatResults() : Response<SatResults>
}