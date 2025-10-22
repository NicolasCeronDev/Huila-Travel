package com.appsnicolas.huilatravel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LugarAdapter(private val listaLugares: List<Lugar>) :
    RecyclerView.Adapter<LugarAdapter.LugarViewHolder>() {

    class LugarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagenLugar: ImageView = view.findViewById(R.id.imagenLugar)
        val nombreLugar: TextView = view.findViewById(R.id.nombreLugar)
        val descripcionLugar: TextView = view.findViewById(R.id.descripcionLugar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugarViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lugar, parent, false)
        return LugarViewHolder(vista)
    }

    override fun onBindViewHolder(holder: LugarViewHolder, position: Int) {
        val lugar = listaLugares[position]
        holder.imagenLugar.setImageResource(lugar.imagen)
        holder.nombreLugar.text = lugar.nombre
        holder.descripcionLugar.text = lugar.descripcion
    }

    override fun getItemCount(): Int = listaLugares.size
}
