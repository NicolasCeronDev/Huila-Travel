package com.appsnicolas.huilatravel.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.appsnicolas.huilatravel.R
import com.appsnicolas.huilatravel.data.model.Lugar
import com.appsnicolas.huilatravel.databinding.ItemHomeBinding

class HomeAdapter(
    private var lugares: List<Lugar> = emptyList() // Start with an empty list
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val lugar = lugares[position]
        holder.bind(lugar)
    }

    override fun getItemCount(): Int = lugares.size

    fun updateData(nuevosLugares: List<Lugar>) {
        lugares = nuevosLugares
        notifyDataSetChanged()
    }

    inner class HomeViewHolder(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(lugar: Lugar) {
            binding.itemTitle.text = lugar.nombre
            binding.itemLocation.text = lugar.ubicacion
            binding.itemRating.text = lugar.calificacion.toString()

            // Cargar la imagen con Coil
            binding.itemImage.load(lugar.urlImagen) {
                placeholder(R.drawable.placeholder_image) // Imagen de mientras carga
                error(R.drawable.error_image)           // Imagen si hay error
                crossfade(true)
            }
        }
    }
}
