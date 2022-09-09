package com.example.mvvm_retrofit_hilt_demo.view_model

import androidx.lifecycle.ViewModel
import com.example.mvvm_retrofit_hilt_demo.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created By Ajeet Singh on 01/09/22
 */
@HiltViewModel
class  MainViewModel @Inject constructor(private val repository: MainRepository):ViewModel() {

    val randomDuck=repository.getDuckData()

}