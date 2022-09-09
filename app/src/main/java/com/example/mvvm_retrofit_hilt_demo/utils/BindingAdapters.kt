package com.example.mvvm_retrofit_hilt_demo.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvvm_retrofit_hilt_demo.R

/**
 * Created By Ajeet Singh on 08/09/22
 */
@BindingAdapter("loadImage")
fun urlToImage(view: AppCompatImageView, s: String?) {
    val options = RequestOptions.placeholderOf(R.drawable.placeholder).error(R.drawable.no_image_available)
    Glide.with(view).setDefaultRequestOptions(options).load(s ?: "").into(view)
}