package com.example.city.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.city.databinding.FragmentRecommendationDetailBinding
import com.example.city.data.Recommendation

class RecommendationDetailFragment : Fragment() {
    private var _binding: FragmentRecommendationDetailBinding? = null
    private val binding get() = _binding!!
    private val args: RecommendationDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecommendationDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recommendation = args.recommendation
        binding.detailName.text = recommendation.name
        binding.detailDescription.text = recommendation.description
        binding.detailImage.setImageResource(recommendation.imageResId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}