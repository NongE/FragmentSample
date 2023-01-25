package com.example.fragmentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentsample.databinding.FragmentBlueBinding
import com.example.fragmentsample.databinding.FragmentRedBinding

class RedFragment : Fragment() {

    private lateinit var binding: FragmentRedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRedBinding.inflate(inflater, container, false)
        return binding.root
    }
}