package com.example.mvvm_retrofit_hilt_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.mvvm_retrofit_hilt_demo.databinding.ActivityMainBinding
import com.example.mvvm_retrofit_hilt_demo.utils.ApiResponse
import com.example.mvvm_retrofit_hilt_demo.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest

/**
 * Created By Ajeet Singh on 01/09/22
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.button.setOnClickListener { loadRandomDuck() }
        loadRandomDuck()
    }

    private fun loadRandomDuck() {
        lifecycleScope.launchWhenCreated {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.randomDuck.collect {
                    when (it) {
                        is ApiResponse.Loading -> {
                            binding.isLoading = true
                        }
                        is ApiResponse.Success -> {
                            binding.isLoading = false
                            binding.randomDuck = it.data
                        }
                        is ApiResponse.Error -> {
                            binding.isLoading = false
                        }
                    }
                }
            }
        }
    }
}