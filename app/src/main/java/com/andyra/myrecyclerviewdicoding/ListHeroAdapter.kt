package com.andyra.myrecyclerviewdicoding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListHeroAdapter (private val listHero: ArrayList<Hero>):RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvname: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvdescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val mview: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(mview)
    }

    override fun onBindViewHolder(mholder: ListViewHolder, mposition: Int) {
        val (name, description, photo) = listHero[mposition]
        Glide.with(mholder.itemView.context)
            .load(photo) // URL Gambar
            .circleCrop() // Mengubah image menjadi lingkaran
            .into(mholder.imgPhoto)
        mholder.tvname.text = name
        mholder.tvdescription.text = description

        mholder.itemView.setOnClickListener(){
            Toast.makeText(mholder.itemView.context, "Kamu memilih " + listHero[mholder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = listHero.size
}