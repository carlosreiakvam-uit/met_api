package com.carlosreiakvam.metapi.air_quality

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.carlosreiakvam.metapi.databinding.FragmentAirQualityBinding

class AirQualityFragment : Fragment() {

    private val airQualityViewModel: AirQualityViewModel by lazy {
        ViewModelProvider(this).get(AirQualityViewModel::class.java)
    }

    lateinit var binding: FragmentAirQualityBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.title = "Air Quality Go"
        binding = FragmentAirQualityBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewmodel = airQualityViewModel
        binding.stationRecyclerview.adapter = StationListAdapter()

        return binding.root
    }

}