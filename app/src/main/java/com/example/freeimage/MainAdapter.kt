package com.example.freeimage

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.freeimage.retrofit.Image

class MainAdapter(var images: List<Image>, var listener: MainActivity.RecyclerItemListener, var context: Context): RecyclerView.Adapter<MainAdapter.MainHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_image_card_main, parent, false)
        val viewHolder = MainHolder(view)
        view.setOnClickListener { v -> listener.onItemClick(v, viewHolder.adapterPosition) }

        return viewHolder
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val image = images[position]
        Log.d("MainAdapter", "Binding image at position $position: $image")

//        holder.userName.text = image.user
//        holder.tags.text = image.tags

        if (image.previewURL.isEmpty()) {
            holder.imageView.setImageDrawable(context.getDrawable(R.drawable.baseline_image_24))
        } else {
            Glide.with(context)
                .load(image.previewURL)
                .into(holder.imageView)
        }

//        if (image.userImageURL.isEmpty()) {
//            holder.userImage.setImageDrawable(context.getDrawable(R.drawable.baseline_image_24))
//        } else {
//            Glide.with(context)
//                .load(image.userImageURL)
//                .into(holder.userImage)
//        }
    }


    override fun getItemCount(): Int {
        return images.size
    }
    fun getItemAtPosition(pos: Int): Image {
        return images[pos]
    }

    inner class MainHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView = view.findViewById(R.id.image_view)
//        var userImage: ImageView = view.findViewById(R.id.user_image)
//        var userName: TextView = view.findViewById(R.id.user_name)
//        var tags: TextView = view.findViewById(R.id.tags)

        init {
            view.setOnClickListener { v: View ->
                listener.onItemClick(v, adapterPosition)
            }
        }

    }


}