// CategoryListFragment.kt
package com.example.city.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.city.R
import com.example.city.viewmodel.RecommendationViewModel

class CategoryListFragment : Fragment() {
    private val viewModel = RecommendationViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_categories)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = CategoryAdapter(viewModel.getCategories()) { category ->
            val action = CategoryListFragmentDirections
                .actionCategoryListFragmentToRecommendationListFragment(category)
            findNavController().navigate(action)
        }

        return view
    }
}