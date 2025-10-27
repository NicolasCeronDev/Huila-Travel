package com.appsnicolas.huilatravel.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appsnicolas.huilatravel.R
import com.appsnicolas.huilatravel.databinding.ItemHomeBinding

data class Place(val name: Int, val image: Int)

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private val places = listOf(
        Place(R.string.place_name_desierto, R.drawable.bg_desierto),
        Place(R.string.place_name_guacharos, R.drawable.guacharos),
        Place(R.string.place_name_nevado, R.drawable.nevado),
        Place(R.string.place_name_parque, R.drawable.ic_parque)

    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(places[position])
    }

    override fun getItemCount(): Int {
        return places.size
    }

    inner class HomeViewHolder(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(place: Place) {
            binding.placeName.text = itemView.context.getString(place.name)
            binding.placeImage.setImageResource(place.image)
        }
    }
}
