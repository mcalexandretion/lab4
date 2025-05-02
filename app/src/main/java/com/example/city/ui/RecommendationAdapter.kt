package com.example.city.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.city.data.Recommendation
import com.example.city.databinding.ItemRecommendationBinding

class RecommendationAdapter(
    private val recommendations: List<Recommendation>,
    private val onItemClick: (Recommendation) -> Unit
) : RecyclerView.Adapter<RecommendationAdapter.RecommendationViewHolder>() {

    inner class RecommendationViewHolder(
        private val binding: ItemRecommendationBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(recommendation: Recommendation) {
            binding.recName.text = recommendation.name
            binding.recDescription.text = recommendation.description
            binding.recImage.setImageResource(recommendation.imageResId)

            binding.root.setOnClickListener {
                onItemClick(recommendation)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationViewHolder {
        val binding = ItemRecommendationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RecommendationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendationViewHolder, position: Int) {
        holder.bind(recommendations[position])
    }

    override fun getItemCount(): Int = recommendations.size
}