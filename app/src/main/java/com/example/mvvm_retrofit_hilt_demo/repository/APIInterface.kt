package com.example.mvvm_retrofit_hilt_demo.repository

import com.example.mvvm_retrofit_hilt_demo.model.DuckResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created By Ajeet Singh on 01/09/22
 */
interface APIInterface {
    @GET("api/v2/random")
    suspend fun getRandomDuck(): Response<DuckResponse>
}