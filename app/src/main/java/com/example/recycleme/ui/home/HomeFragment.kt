package com.example.recycleme.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recycleme.R
import com.example.recycleme.databinding.FragmentHomeBinding
import com.example.recycleme.ui.scan.ScanActivity
import com.google.firebase.auth.FirebaseAuth

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment using View Binding
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize your views and set listeners here
        binding.ButtonStartRecycling.setOnClickListener {
            val intent = Intent(activity, ScanActivity::class.java)
            startActivity(intent)
        }

        binding.ButtonVoucherSeeMore.setOnClickListener {
            // Handle See More button click
        }

        // Set up any other views here
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}