package com.carlosreiakvam.metapi.air_quality

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.carlosreiakvam.metapi.databinding.FragmentAirQualityBinding

class AirQualityFragment : Fragment() {
    lateinit var binding: FragmentAirQualityBinding

    private val viewModel: AirQualityViewModel by lazy {
        ViewModelProvider(this)[AirQualityViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAirQualityBinding.inflate(inflater)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

}