package com.example.nasapictures.ui.home.adapter

import android.annotation.SuppressLint
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.nasapictures.R
import com.example.nasapictures.databinding.ListItemPictureBinding
import com.example.nasapictures.model.PictureFile
import kotlin.random.Random

class PicturesAdapter : RecyclerView.Adapter<PicturesAdapter.PictureViewHolder>() {
    private var mPictures: List<PictureFile> = mutableListOf()
    private var mLastPosition = -1

    @SuppressLint("NotifyDataSetChanged")
    fun setPicturesData(pictures: List<PictureFile>) {
        this.mPictures = pictures
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        return PictureViewHolder(ListItemPictureBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder.v.picture = mPictures[position]
        holder.v.executePendingBindings()
        setAnimation(holder.itemView, position)
        holder.itemView.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_navigation_home_to_details, bundleOf().apply {
                    putParcelableArrayList("pictures_list", mPictures as ArrayList<out Parcelable>)
                    putInt("position", position)
                }, null, null)
        }
    }

    override fun getItemCount(): Int = mPictures.size

    private fun setAnimation(viewToAnimate: View, position: Int) {
        if (position > mLastPosition) {
            val anim = ScaleAnimation(
                0.0f,
                1.0f,
                0.0f,
                1.0f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            )
            anim.duration = Random.nextLong(501)
            viewToAnimate.startAnimation(anim)
            mLastPosition = position
        }
    }

    inner class PictureViewHolder(val v: ListItemPictureBinding) : RecyclerView.ViewHolder(v.root)
}