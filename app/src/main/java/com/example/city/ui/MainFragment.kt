package com.example.city.ui

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.city.R

class MainFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        view.findViewById<Button>(R.id.button_start).setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_categoryListFragment)
        }
        return view
    }
}
