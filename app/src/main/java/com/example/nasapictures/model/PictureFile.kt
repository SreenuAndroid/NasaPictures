package com.example.nasapictures.model

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.example.nasapictures.R
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PictureFile(
    val copyright: String?,
    val date: String,
    val explanation: String,
    @SerializedName("hdurl")
    val hdUrl: String,
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("service_version")
    val serviceVersion: String,
    val title: String,
    val url: String,
) : Parcelable {
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