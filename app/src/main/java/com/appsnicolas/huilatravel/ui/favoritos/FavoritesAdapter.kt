package com.appsnicolas.huilatravel.ui.favoritos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.appsnicolas.huilatravel.databinding.ItemRouteBinding
import com.appsnicolas.huilatravel.route.Route

class FavoritesAdapter(
    private val onItemClick: (Route) -> Unit,
    private val onRemoveClick: (Route) -> Unit
) : ListAdapter<Route, FavoritesAdapter.FavViewHolder>(DIFF) {

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<Route>() {
            override fun areItemsTheSame(oldItem: Route, newItem: Route) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Route, newItem: Route) = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val binding = ItemRouteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class FavViewHolder(private val b: ItemRouteBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(route: Route) {
            b.tvTitle.text = route.title
            b.tvDuration.text = route.duration
            b.tvTransport.text = route.transport
            b.tvSites.text = "${route.sites} Sitios"
            b.tvDescription.text = route.description
            b.imgRoute.load(route.imageRes) { crossfade(true) }
            b.root.setOnClickListener { onItemClick(route) }
            b.btnFavorite.setImageResource(com.appsnicolas.huilatravel.R.drawable.ic_favorite)
            b.btnFavorite.setOnClickListener { onRemoveClick(route) }
            b.btnItinerary.visibility = android.view.View.GONE
        }
    }
}
