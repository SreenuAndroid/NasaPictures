package com.example.nasapictures.ui.home.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nasapictures.databinding.ListItemDetailBinding
import com.example.nasapictures.model.PictureFile

class DetailsPagerAdapter(
    private val mPictures: List<PictureFile>,
    private val mClickListener: (PictureFile, Int) -> Unit
) : RecyclerView.Adapter<DetailsPagerAdapter.DetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            ListItemDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.v.picture = mPictures[position]
        holder.v.executePendingBindings()
        holder.itemView.setOnClickListener {
            mClickListener.invoke(holder.v.picture!!, position)
        }
    }

    override fun getItemCount(): Int = mPictures.size

    inner class DetailViewHolder(val v: ListItemDetailBinding) : RecyclerView.ViewHolder(v.root)
}