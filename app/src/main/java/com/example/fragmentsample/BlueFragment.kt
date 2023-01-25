package com.example.fragmentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentsample.databinding.FragmentBlueBinding

class BlueFragment : Fragment() {

    private lateinit var binding: FragmentBlueBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlueBinding.inflate(inflater, container, false)
        return binding.root
    }
}