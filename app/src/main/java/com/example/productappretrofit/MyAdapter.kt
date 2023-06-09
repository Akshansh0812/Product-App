package com.example.productappretrofit

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(private val context : Activity, private val productArrayList : List<Product>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.eachitem, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = productArrayList[position]
        holder.title.text = currentItem.title

        Picasso.get().load(currentItem.thumbnail).into(holder.image)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    class MyViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
        val title : TextView
        val image : ShapeableImageView

        init{
            title = itemView.findViewById(R.id.productTitle)
            image = itemView.findViewById(R.id.productImage)
        }
    }

}
