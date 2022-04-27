package com.carlosreiakvam.metapi

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.carlosreiakvam.metapi.air_quality.StationListAdapter


@BindingAdapter("listStations")
fun bindStationView(recyclerView: RecyclerView, data: List<Station>?) {
    val adapter = recyclerView.adapter as StationListAdapter
    adapter.submitList(data)

}

