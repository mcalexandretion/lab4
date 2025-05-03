package com.example.city.viewmodel

import androidx.lifecycle.ViewModel
import com.example.city.data.Recommendation
import com.example.city.data.RecommendationRepository

class RecommendationViewModel : ViewModel() {
    fun getCategories() = RecommendationRepository.getCategories()

    fun getRecommendations(category: String): List<Recommendation> {
        return RecommendationRepository.getRecommendationsByCategory(category)
    }
}