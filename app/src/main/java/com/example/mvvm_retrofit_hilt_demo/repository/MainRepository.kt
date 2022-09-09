package com.example.mvvm_retrofit_hilt_demo.repository

import com.example.mvvm_retrofit_hilt_demo.utils.result
import javax.inject.Inject

/**
 * Created By Ajeet Singh on 02/09/22
 */
class MainRepository @Inject constructor(private val apiInterface: APIInterface) {
    fun getDuckData() = result {
        apiInterface.getRandomDuck()
    }
}