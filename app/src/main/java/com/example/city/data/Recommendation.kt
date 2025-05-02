package com.example.city.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recommendation(
    val name: String,
    val description: String,
    val imageResId: Int
) : Parcelable