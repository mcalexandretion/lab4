package com.example.city.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.city.R
import com.example.city.data.Recommendation

class RecommendationAdapter(private val list: List<Recommendation>) :
    RecyclerView.Adapter<RecommendationAdapter.RecViewHolder>() {

    inner class RecViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.rec_name)
        val description: TextView = view.findViewById(R.id.rec_description)
        val image: ImageView = view.findViewById(R.id.rec_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recommendation, parent, false)
        return RecViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecViewHolder, position: Int) {
        val item = list[position]
        holder.name.text = item.name
        holder.description.text = item.description
        holder.image.setImageResource(item.imageResId)
    }

    override fun getItemCount(): Int = list.size
}
