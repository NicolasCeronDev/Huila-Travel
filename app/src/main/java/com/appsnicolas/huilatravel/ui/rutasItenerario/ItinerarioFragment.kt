package com.appsnicolas.huilatravel.ui.rutasItenerario

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.appsnicolas.huilatravel.databinding.FragmentItinerarioBinding

class ItinerarioFragment : Fragment() {

    private var _binding: FragmentItinerarioBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ItineraryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentItinerarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val routeTitle = arguments?.getString("routeTitle") ?: "Ruta"
        binding.tvTitleItinerario.text = "Itinerario: $routeTitle"

        adapter = ItineraryAdapter { step ->
            Toast.makeText(requireContext(), "Ver lugar: ${step.title}", Toast.LENGTH_SHORT).show()
        }
        binding.rvItinerary.layoutManager = LinearLayoutManager(requireContext())
        binding.rvItinerary.adapter = adapter
        adapter.submitList(SampleItinerary.steps)

        binding.btnStartRoute.setOnClickListener {
            Toast.makeText(requireContext(), "Ruta iniciada", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
