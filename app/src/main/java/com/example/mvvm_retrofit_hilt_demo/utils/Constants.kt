package com.example.mvvm_retrofit_hilt_demo.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

/**
 * Created By Ajeet Singh on 08/09/22
 */

fun <T> result(call: suspend () -> Response<T>): Flow<ApiResponse<T?>> = flow {
    emit(ApiResponse.Loading)
    try {
        val apiCall = call()
        apiCall.let { response ->
            if (response.isSuccessful) {
                emit(ApiResponse.Success(response.body()))
            } else {
                response.errorBody()?.let { error->
                    error.close()
                    emit(ApiResponse.Error(error.toString()))
                }
            }

        }
    } catch (e: Throwable) {
        e.printStackTrace()
        emit(ApiResponse.Error(e.message.toString()))
    }
}