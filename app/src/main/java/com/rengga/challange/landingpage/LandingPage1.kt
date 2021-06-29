package com.rengga.challange.landingpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rengga.challange.databinding.FragmentLandingPage1Binding


class LandingPage1 : Fragment() {

    private lateinit var binding: FragmentLandingPage1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLandingPage1Binding.inflate(inflater, container, false)
        return binding.root
    }
}