package com.geeks.emil_maldybaev_hw5_3_pinterest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.geeks.emil_maldybaev_hw5_3_pinterest.databinding.ItemImageBinding

class ImageAdapter(private val list: ArrayList<ImageModel>) : Adapter<ImageAdapter.ImageViewHolder>() {
    inner class ImageViewHolder(val binding: ItemImageBinding) : ViewHolder(binding.root) {
        fun onBind(image:ImageModel){
            binding.pixaImage.load(image.largeImageURL)
        }
    }
    fun addNewImages(list: ArrayList<ImageModel>){
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(list[position])
    }

}