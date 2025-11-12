package com.appsnicolas.huilatravel.ui.rutasItenerario

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.appsnicolas.huilatravel.databinding.ItemItinerarioBinding

class ItineraryAdapter(
    private val onVerLugarClick: (ItineraryStep) -> Unit
) : ListAdapter<ItineraryStep, ItineraryAdapter.StepViewHolder>(DIFF) {

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<ItineraryStep>() {
            override fun areItemsTheSame(oldItem: ItineraryStep, newItem: ItineraryStep) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: ItineraryStep, newItem: ItineraryStep) = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepViewHolder {
        val binding = ItemItinerarioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StepViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StepViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class StepViewHolder(private val b: ItemItinerarioBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(step: ItineraryStep) {
            b.tvStepNumber.text = step.number.toString()
            b.tvStepTitle.text = step.title
            b.tvStepSubtitle.text = step.subtitle
            b.tvStepTime.text = step.timeRange
            b.btnVerLugar.setOnClickListener { onVerLugarClick(step) }
        }
    }
}
