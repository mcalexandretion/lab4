package com.example.city.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.city.databinding.FragmentRecommendationListBinding
import com.example.city.viewmodel.RecommendationViewModel

class RecommendationListFragment : Fragment() {
    private var _binding: FragmentRecommendationListBinding? = null
    private val binding get() = _binding!!
    private val args: RecommendationListFragmentArgs by navArgs()
    private val viewModel: RecommendationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecommendationListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryName = args.categoryName
        binding.categoryName.text = categoryName

        val recommendations = viewModel.getRecommendations(categoryName)

        binding.recyclerViewRecommendations.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = RecommendationAdapter(recommendations) { recommendation ->
                val action = RecommendationListFragmentDirections
                    .actionRecommendationListFragmentToRecommendationDetailFragment(recommendation)
                findNavController().navigate(action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}