package com.github.mishkaff89.fitnessnote.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.mishkaff89.fitnessnote.R
import com.github.mishkaff89.fitnessnote.databinding.TrainingItemBinding
import com.github.mishkaff89.fitnessnote.entity.TrainingItem

class AdapterTraining(private val listener: Listener): RecyclerView.Adapter<AdapterTraining.TrainingHolder>() {
    private var list = mutableListOf<TrainingItem>()


    class TrainingHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = TrainingItemBinding.bind(item)
        fun setData(trainingItem: TrainingItem, listener: Listener) = with(binding){

            tvTitleTraining.text = trainingItem.name
            tvTimeTraining.text = trainingItem.time

            itemView.setOnClickListener {
                listener.onClickItem(trainingItem)
            }

            buttonDeleteTraining.setOnClickListener {
                listener.deleteItem(trainingItem.id!!)
            }

            buttonEditTraining.setOnClickListener {
                listener.updateItem(trainingItem)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingHolder {
        val inflater = LayoutInflater.from(parent.context)
        return  TrainingHolder(inflater.inflate(R.layout.training_item, parent,false))
    }

    override fun onBindViewHolder(holder: TrainingHolder, position: Int) {
        list.sortByDescending { it.id }
        holder.setData(list[position], listener)

    }

    override fun getItemCount(): Int {
       return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(listItems: List<TrainingItem>){
        list.clear()
        list.addAll(listItems)
        notifyDataSetChanged()

    }

    interface Listener{
        fun deleteItem(id: Int)
        fun onClickItem(trainingItem: TrainingItem)
        fun updateItem(item: TrainingItem)
    }
}