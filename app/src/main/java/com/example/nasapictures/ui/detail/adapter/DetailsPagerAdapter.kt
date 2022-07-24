package com.example.nasapictures.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.nasapictures.R
import com.example.nasapictures.databinding.ListItemDetailBinding
import com.example.nasapictures.model.PictureFile

class DetailsPagerAdapter(private val mPictures: List<PictureFile>) : RecyclerView.Adapter<DetailsPagerAdapter.DetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(ListItemDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.v.picture = mPictures[position]
        holder.v.executePendingBindings()
        holder.itemView.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_navigation_details_to_full_picture, bundleOf().apply {
                    putParcelable("picture", holder.v.picture)
                }, null, null)
        }
    }

    override fun getItemCount(): Int = mPictures.size

    inner class DetailViewHolder(val v: ListItemDetailBinding) : RecyclerView.ViewHolder(v.root)
}