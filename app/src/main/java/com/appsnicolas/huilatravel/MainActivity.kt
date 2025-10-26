package com.appsnicolas.huilatravel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerLugares: RecyclerView
    private lateinit var fabExplorar: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerLugares = findViewById(R.id.recyclerLugares)
        fabExplorar = findViewById(R.id.fabExplorar)

        // Configurar el RecyclerView como carrusel horizontal
        recyclerLugares.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Datos de ejemplo
        val lugares = listOf(
            Lugar("Desierto de la Tatacoa", "Un paisaje árido y mágico", R.drawable.tatacoa),
            Lugar("Cueva de los Guácharos", "Parque natural lleno de vida", R.drawable.guacharos),
            Lugar("Represa de Betania", "Bellos paisajes y deportes acuáticos", R.drawable.betania),
            Lugar("Nevado del Huila", "El punto más alto del sur colombiano", R.drawable.nevado)
        )

        recyclerLugares.adapter = LugarAdapter(lugares)

        fabExplorar.setOnClickListener {
            Toast.makeText(this, "Explorando lugares cercanos...", Toast.LENGTH_SHORT).show()
        }
    }
}
