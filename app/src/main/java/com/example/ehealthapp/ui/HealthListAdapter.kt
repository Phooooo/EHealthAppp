package com.example.ehealthapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ehealthapp.R
import com.example.ehealthapp.model.Health

class HealthListAdapter(
    private val onItemClickListener: (Health) -> Unit
): ListAdapter<Health, HealthListAdapter.HealthViewModel>(WORDS_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthViewModel {
        return HealthViewModel.create(parent)
    }

    override fun onBindViewHolder(holder: HealthViewModel, position: Int) {
        val health = getItem(position)
        holder.bind(health)
        holder.itemView.setOnClickListener {
            onItemClickListener(health)
        }
    }

    class HealthViewModel (itemView: View): RecyclerView.ViewHolder(itemView) {
        private val nametextview: TextView = itemView.findViewById(R.id.nametextview)
        private val addrestextview: TextView = itemView.findViewById(R.id.addresstextview)
        private val phonenumbertextview: TextView = itemView.findViewById(R.id.phonenumbertextview)

        fun bind(health: Health?) {
            nametextview.text = health?.name
            addrestextview.text = health?.address
            phonenumbertextview.text = health?.phonenumber

        }

        companion object {
            fun create(parent: ViewGroup): HealthListAdapter.HealthViewModel {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_health, parent, false)
                return HealthViewModel(view)
            }
        }
    }
    companion object{
        private val WORDS_COMPARATOR = object : DiffUtil.ItemCallback<Health>(){
            override fun areItemsTheSame(oldItem: Health, newItem: Health): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Health, newItem: Health): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}
