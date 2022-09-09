package com.example.mvvm_retrofit_hilt_demo.hilt

import com.example.mvvm_retrofit_hilt_demo.BuildConfig
import com.example.mvvm_retrofit_hilt_demo.repository.APIInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created By Ajeet Singh on 01/09/22
 */
@Module
@InstallIn(SingletonComponent::class)
class HiltModules {
    /**
     * Will provide MealAPIInterface object where required
     */
    @Provides
    @Singleton
    fun provideMealSearchAPI(): APIInterface {
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(APIInterface::class.java)
    }
}