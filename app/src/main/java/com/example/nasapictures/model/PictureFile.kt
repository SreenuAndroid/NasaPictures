package com.example.nasapictures.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.nasapictures.R

data class PictureFile(
    val copyright: String,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val media_type: String,
    val service_version: String,
    val title: String,
    val url: String,
) {
    companion object {
        @JvmStatic
        @BindingAdapter("app:loadImage")
        fun loadImage(view: ImageView, imageUrl: String?) {
            imageUrl ?: return
            view.load(imageUrl) {
                crossfade(true)
                crossfade(500)
                placeholder(R.drawable.ic_loading_animated)
            }
        }
    }
}