package com.example.nasapictures.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nasapictures.model.PictureFile
import com.example.nasapictures.databinding.ListItemPictureBinding

class PicturesAdapter : RecyclerView.Adapter<PicturesAdapter.PictureViewHolder>() {
    private var mPictures: List<PictureFile> = mutableListOf()

    fun setPicturesData(pictures: List<PictureFile>) {
        this.mPictures = pictures
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        return PictureViewHolder(ListItemPictureBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder.v.executePendingBindings()
        holder.v.picture = mPictures[position]
    }

    override fun getItemCount(): Int = mPictures.size

    inner class PictureViewHolder(val v: ListItemPictureBinding) : RecyclerView.ViewHolder(v.root)
}