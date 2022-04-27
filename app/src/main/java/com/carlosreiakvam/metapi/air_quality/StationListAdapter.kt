package com.carlosreiakvam.metapi.air_quality

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.carlosreiakvam.metapi.Station
import com.carlosreiakvam.metapi.databinding.SingleTextItemBinding


class StationListAdapter : ListAdapter
<Station, StationListAdapter.StationViewHolder>(DiffCallback) {

    class StationViewHolder(private var binding: SingleTextItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(station: Station) {
            binding.station = station
            binding.executePendingBindings()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationViewHolder {
        return StationViewHolder(SingleTextItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: StationViewHolder, position: Int) {
        val station = getItem(position)
        holder.bind(station)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Station>() {
        override fun areItemsTheSame(oldItem: Station, newItem: Station): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Station, newItem: Station): Boolean {
            return oldItem.name == newItem.name
        }
    }

}