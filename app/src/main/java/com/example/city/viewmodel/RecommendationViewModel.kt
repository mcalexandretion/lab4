package com.example.city.viewmodel

import androidx.lifecycle.ViewModel
import com.example.city.R
import com.example.city.data.Recommendation

class RecommendationViewModel : ViewModel() {
    val recommendations = mapOf(
        "Кофейни" to listOf(
            Recommendation("Кофе на Крыше", "Вид на город", R.drawable.image1),
            Recommendation("Кофейня 812", "Лучший капучино", R.drawable.image1)
        ),
        "Парки" to listOf(
            Recommendation("Парк 300-летия", "У моря", R.drawable.image1),
            Recommendation("Елагин остров", "Природа в городе", R.drawable.image1)
        ),
        "Для детей" to listOf(
            Recommendation("Океанариум", "Мир под водой", R.drawable.image1),
            Recommendation("Зоопарк", "Животные и развлечения", R.drawable.image1)
        )
    )
}