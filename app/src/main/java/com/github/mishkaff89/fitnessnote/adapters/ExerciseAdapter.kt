package com.github.mishkaff89.fitnessnote.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.mishkaff89.fitnessnote.R
import com.github.mishkaff89.fitnessnote.databinding.ExerciseItemBinding
import com.github.mishkaff89.fitnessnote.entity.ExerciseItem

class ExerciseAdapter(private val listener: Listener): ListAdapter<ExerciseItem, ExerciseAdapter.ItemHolder>(ItemComporator()) {


    class ItemHolder(item: View): RecyclerView.ViewHolder(item){
        private val binding = ExerciseItemBinding.bind(item)

        fun setData(exerciseItem: ExerciseItem, listener: Listener) = with(binding) {
            tvNameExercise.text = exerciseItem.name
            curentTime.text = exerciseItem.time
            tvValue11.text = exerciseItem.value1_1
            tvValue12.text = exerciseItem.value1_2
            tvValue13.text = exerciseItem.value1_3
            tvValue14.text = exerciseItem.value1_4
            tvValue15.text = exerciseItem.value1_5
            tvValue16.text = exerciseItem.value1_6
            tvValue17.text = exerciseItem.value1_7
            tvValue18.text = exerciseItem.value1_8
            tvValue19.text = exerciseItem.value1_9
            tvValue110.text = exerciseItem.value1_10

            tvValue21.text = exerciseItem.value2_1
            tvValue22.text = exerciseItem.value2_2
            tvValue23.text = exerciseItem.value2_3
            tvValue24.text = exerciseItem.value2_4
            tvValue25.text = exerciseItem.value2_5
            tvValue26.text = exerciseItem.value2_6
            tvValue27.text = exerciseItem.value2_7
            tvValue28.text = exerciseItem.value2_8
            tvValue29.text = exerciseItem.value2_9
            tvValue210.text = exerciseItem.value2_10

            if (exerciseItem.type == 1) {
                exerciseBg.setBackgroundResource(R.color.bg_card_cardio)
                Values1.setText(R.string.values_time)
                Values2.setText(R.string.values_distance)
                bgCard.setBackgroundResource(R.drawable.bg_card_cardio)
                bgCardIm.setImageResource(R.drawable.cardiobg)

                tvValue21.text = "${tvValue21.text} km"
                tvValue12.visibility = View.GONE
                tvValue13.visibility = View.GONE
                tvValue14.visibility = View.GONE
                tvValue15.visibility = View.GONE
                tvValue16.visibility = View.GONE
                tvValue17.visibility = View.GONE
                tvValue18.visibility = View.GONE
                tvValue19.visibility = View.GONE
                tvValue110.visibility = View.GONE

                tvValue22.visibility = View.GONE
                tvValue23.visibility = View.GONE
                tvValue24.visibility = View.GONE
                tvValue25.visibility = View.GONE
                tvValue26.visibility = View.GONE
                tvValue27.visibility = View.GONE
                tvValue28.visibility = View.GONE
                tvValue29.visibility = View.GONE
                tvValue210.visibility = View.GONE



            } else {
                exerciseBg.setBackgroundResource(R.color.bg_card_ex)
                Values1.setText(R.string.values_weight)
                Values2.setText(R.string.values_quantity)
                bgCard.setBackgroundResource(R.drawable.bg_card_ex)
                tvValue11.text = "${tvValue11.text} kg"
                bgCardIm.setImageResource(R.drawable.gymbg)

                if (tvValue110.text == "") {
                    tvValue110.visibility = View.GONE
                    tvValue210.visibility = View.GONE
                    if (tvValue19.text == "") {
                        tvValue19.visibility = View.GONE
                        tvValue29.visibility = View.GONE

                        if (tvValue18.text == "") {
                            tvValue18.visibility = View.GONE
                            tvValue28.visibility = View.GONE

                            if (tvValue17.text == "") {
                                tvValue17.visibility = View.GONE
                                tvValue27.visibility = View.GONE

                                if (tvValue16.text == "") {
                                    tvValue16.visibility = View.GONE
                                    tvValue26.visibility = View.GONE

                                    if (tvValue15.text == "") {
                                        tvValue15.visibility = View.GONE
                                        tvValue25.visibility = View.GONE

                                        if (tvValue14.text == "") {
                                            tvValue14.visibility = View.GONE
                                            tvValue24.visibility = View.GONE

                                            if (tvValue13.text == "") {
                                                tvValue13.visibility = View.GONE
                                                tvValue23.visibility = View.GONE

                                                if (tvValue12.text == "") {
                                                    tvValue12.visibility = View.GONE
                                                    tvValue22.visibility = View.GONE
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if(tvValue12.text.isNotEmpty())tvValue12.text = "${tvValue12.text} kg"
                if(tvValue13.text.isNotEmpty())tvValue13.text = "${tvValue13.text} kg"
                if(tvValue14.text.isNotEmpty())tvValue14.text = "${tvValue14.text} kg"
                if(tvValue15.text.isNotEmpty())tvValue15.text = "${tvValue15.text} kg"
                if(tvValue16.text.isNotEmpty())tvValue16.text = "${tvValue16.text} kg"
                if(tvValue17.text.isNotEmpty())tvValue17.text = "${tvValue17.text} kg"
                if(tvValue18.text.isNotEmpty())tvValue18.text = "${tvValue18.text} kg"
                if(tvValue19.text.isNotEmpty())tvValue19.text = "${tvValue19.text} kg"
                if(tvValue110.text.isNotEmpty())tvValue110.text = "${tvValue110.text} kg"



            }



            imEditExercise.setOnClickListener {
                listener.updateItem(exerciseItem)
            }

            imDeleteExercise.setOnClickListener {
                listener.deleteItem(exerciseItem.id!!)
            }
        }

        companion object{
            fun create(parent: ViewGroup): ItemHolder{
                return ItemHolder(
                    LayoutInflater.from(parent.context).
                inflate(R.layout.exercise_item, parent, false))
            }
        }
    }

    class ItemComporator: DiffUtil.ItemCallback<ExerciseItem>(){
        override fun areItemsTheSame(oldItem: ExerciseItem, newItem: ExerciseItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ExerciseItem, newItem: ExerciseItem): Boolean {
            return oldItem == newItem
        }

    }

    interface Listener{
        fun deleteItem(id: Int)
        fun updateItem(exerciseItem: ExerciseItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(getItem(position), listener)
    }


}