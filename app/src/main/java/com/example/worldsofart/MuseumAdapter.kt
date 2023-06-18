package com.example.worldsofart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MuseumAdapter (private val context: Context, private val museum: List<Museum>, val listener: (Museum) -> Unit)
    : RecyclerView.Adapter<MuseumAdapter.AnimeViewHolder>(){
    class AnimeViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val imgmuseum = view.findViewById<ImageView>(R.id.img_item_photo)
        val namemuseum = view.findViewById<TextView>(R.id.tv_item_name)
        val descmuseum = view.findViewById<TextView>(R.id.tv_item_description)

        fun bindView(museum: Museum, listener: (Museum) -> Unit){
            imgmuseum.setImageResource(museum.imgmuseum)
            namemuseum.text = museum.namemuseum
            descmuseum.text = museum.descmuseum
            itemView.setOnClickListener{
                (listener(museum))
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_museum, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bindView(museum[position], listener)
    }

    override fun getItemCount(): Int = museum.size

}