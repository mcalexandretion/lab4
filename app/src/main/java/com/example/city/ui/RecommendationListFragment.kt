package com.example.city.ui


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.city.R
import com.example.city.viewmodel.RecommendationViewModel
import com.example.city.data.Recommendation
class RecommendationListFragment : Fragment() {

    private var categoryName: String? = null

    // Делаем это через safe args (если ты хочешь передавать данные через навигацию)
    val args: RecommendationListFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Получаем категорию из аргументов
        categoryName = args.categoryName
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recommendation_list, container, false)

        // Пример списка рекомендаций
        val recommendations = when (categoryName) {
            "Кофейни" -> listOf(
                Recommendation("Ресторан 1", "Лучшее место для ужина", R.drawable.image1),
                Recommendation("Ресторан 2", "Популярное кафе", R.drawable.image1)
            )
            "Достопримечательности" -> listOf(
                Recommendation("Музей 1", "Интересная коллекция", R.drawable.image1),
                Recommendation("Парк 1", "Прекрасное место для прогулок", R.drawable.image1)
            )
            else -> listOf(
                Recommendation("Нет рекомендаций", "Для данной категории нет рекомендаций", R.drawable.image1)
            )
        }

        // Настроим RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_recommendations)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = RecommendationAdapter(recommendations)

        // Покажем выбранную категорию
        val categoryTextView = view.findViewById<TextView>(R.id.category_name)
        categoryTextView.text = categoryName ?: "Не выбрана"

        return view
    }
}


