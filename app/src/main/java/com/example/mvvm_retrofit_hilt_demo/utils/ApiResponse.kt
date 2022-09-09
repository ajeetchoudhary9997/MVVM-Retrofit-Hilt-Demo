package com.example.mvvm_retrofit_hilt_demo.utils

/**
 * Created By Ajeet Singh on 02/09/22
 */
sealed interface ApiResponse<out T> {
    data class Success<out R>(val data: R?) : ApiResponse<R?>
    data class Error(val msg: String?) : ApiResponse<Nothing>
    object Loading : ApiResponse<Nothing>
}
