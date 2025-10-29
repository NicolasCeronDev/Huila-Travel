package com.appsnicolas.huilatravel.ui.rutas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.appsnicolas.huilatravel.route.Route
import com.appsnicolas.huilatravel.databinding.ItemRouteBinding

class RoutesAdapter(private val onClick: (Route) -> Unit) :
    ListAdapter<Route, RoutesAdapter.RouteViewHolder>(DIFF) {

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<Route>() {
            override fun areItemsTheSame(oldItem: Route, newItem: Route) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Route, newItem: Route) = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RouteViewHolder {
        val binding = ItemRouteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RouteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RouteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RouteViewHolder(private val b: ItemRouteBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(route: Route) {
            b.tvTitle.text = route.title
            b.tvDuration.text = route.duration
            b.tvTransport.text = route.transport
            b.tvSites.text = "${route.sites} Sitios"
            b.tvDescription.text = route.description
            b.imgRoute.load(route.imageRes) {
                crossfade(true)
            }

            b.root.setOnClickListener { onClick(route) }
            b.btnItinerary.setOnClickListener { }
            b.btnFavorite.setOnClickListener { }
        }
    }
}