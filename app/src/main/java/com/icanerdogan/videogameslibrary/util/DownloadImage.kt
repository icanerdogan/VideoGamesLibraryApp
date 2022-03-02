package com.icanerdogan.videogameslibrary.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

fun ImageView.downloadFromURL(URL : String?){
    Glide.with(context)
        .load(URL)
        .into(this)
}

@BindingAdapter("android:downloadURL")
fun downloadImage(view : ImageView, URL: String?){
    view.downloadFromURL(URL)
}