package com.github.mishkaff89.fitnessnote.dialogs

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
import com.github.mishkaff89.fitnessnote.databinding.EditExerciseDialogBinding
import com.github.mishkaff89.fitnessnote.entity.ExerciseItem

object UpdateExerciseDialog {
    fun showDialog(context: Context, exerciseItem: ExerciseItem,listener: Listener){
        var dialog: AlertDialog? = null
        val builder = AlertDialog.Builder(context)
        val binding = EditExerciseDialogBinding.inflate(LayoutInflater.from(context))
        builder.setView(binding.root)
        binding.apply {
            edNameExe.setText(exerciseItem.name)
            edNameExe.requestFocus()
            edValue11.setText(exerciseItem.value1_1)
            edValue12.setText(exerciseItem.value1_2)
            edValue13.setText(exerciseItem.value1_3)
            edValue14.setText(exerciseItem.value1_4)
            edValue15.setText(exerciseItem.value1_5)
            edValue16.setText(exerciseItem.value1_6)
            edValue17.setText(exerciseItem.value1_7)
            edValue18.setText(exerciseItem.value1_8)
            edValue19.setText(exerciseItem.value1_9)
            edValue110.setText(exerciseItem.value1_10)

            edValue21.setText(exerciseItem.value2_1)
            edValue22.setText(exerciseItem.value2_2)
            edValue23.setText(exerciseItem.value2_3)
            edValue24.setText(exerciseItem.value2_4)
            edValue25.setText(exerciseItem.value2_5)
            edValue26.setText(exerciseItem.value2_6)
            edValue27.setText(exerciseItem.value2_7)
            edValue28.setText(exerciseItem.value2_8)
            edValue29.setText(exerciseItem.value2_9)
            edValue210.setText(exerciseItem.value2_10)


                if(edValue12.text.isEmpty()){
                    cardView12.visibility = View.GONE
                    cardView22.visibility = View.GONE
                }
                if(edValue13.text.isEmpty()) {
                    cardView13.visibility = View.GONE
                    cardView23.visibility = View.GONE
                }
                if(edValue14.text.isEmpty()) {
                    cardView14.visibility = View.GONE
                    cardView24.visibility = View.GONE
                }
                if(edValue15.text.isEmpty()) {
                    cardView15.visibility = View.GONE
                    cardView25.visibility = View.GONE
                }
                if(edValue16.text.isEmpty()) {
                    cardView16.visibility = View.GONE
                    cardView26.visibility = View.GONE
                }
                if(edValue17.text.isEmpty()) {
                    cardView17.visibility = View.GONE
                    cardView27.visibility = View.GONE
                }
                if(edValue18.text.isEmpty()) {
                    cardView18.visibility = View.GONE
                    cardView28.visibility = View.GONE
                }
                if(edValue19.text.isEmpty()) {
                    cardView19.visibility = View.GONE
                    cardView29.visibility = View.GONE
                }
                if(edValue110.text.isEmpty()) {
                    cardView110.visibility = View.GONE
                    cardView210.visibility = View.GONE
                }




            imShowValue.setOnClickListener {
                imShowValue.visibility = View.GONE
                imCloseValue.visibility = View.VISIBLE

                cardView12.visibility = View.VISIBLE
                cardView13.visibility = View.VISIBLE
                cardView14.visibility = View.VISIBLE
                cardView15.visibility = View.VISIBLE
                cardView16.visibility = View.VISIBLE
                cardView17.visibility = View.VISIBLE
                cardView18.visibility = View.VISIBLE
                cardView19.visibility = View.VISIBLE
                cardView110.visibility = View.VISIBLE

                cardView22.visibility = View.VISIBLE
                cardView23.visibility = View.VISIBLE
                cardView24.visibility = View.VISIBLE
                cardView25.visibility = View.VISIBLE
                cardView26.visibility = View.VISIBLE
                cardView27.visibility = View.VISIBLE
                cardView28.visibility = View.VISIBLE
                cardView29.visibility = View.VISIBLE
                cardView210.visibility = View.VISIBLE
            }

            imCloseValue.setOnClickListener {
                imShowValue.visibility = View.VISIBLE
                imCloseValue.visibility = View.GONE

                if(edValue12.text.isEmpty()){
                    cardView12.visibility = View.GONE
                    cardView22.visibility = View.GONE
                }
                if(edValue13.text.isEmpty()) {
                    cardView13.visibility = View.GONE
                    cardView23.visibility = View.GONE
                }
                if(edValue14.text.isEmpty()) {
                    cardView14.visibility = View.GONE
                    cardView24.visibility = View.GONE
                }
                if(edValue15.text.isEmpty()) {
                    cardView15.visibility = View.GONE
                    cardView25.visibility = View.GONE
                }
                if(edValue16.text.isEmpty()) {
                    cardView16.visibility = View.GONE
                    cardView26.visibility = View.GONE
                }
                if(edValue17.text.isEmpty()) {
                    cardView17.visibility = View.GONE
                    cardView27.visibility = View.GONE
                }
                if(edValue18.text.isEmpty()) {
                    cardView18.visibility = View.GONE
                    cardView28.visibility = View.GONE
                }
                if(edValue19.text.isEmpty()) {
                    cardView19.visibility = View.GONE
                    cardView29.visibility = View.GONE
                }
                if(edValue110.text.isEmpty()) {
                    cardView110.visibility = View.GONE
                    cardView210.visibility = View.GONE
                }
            }

            bSaveExe.setOnClickListener {

                if (edNameExe.text.toString().isNotEmpty()){
                    listener.onClick(exerciseItem.copy(
                        name = edNameExe.text.toString(),
                        value1_1 = edValue11.text.toString(),
                        value1_2 = edValue12.text.toString(),
                        value1_3 = edValue13.text.toString(),
                        value1_4 = edValue14.text.toString(),
                        value1_5 = edValue15.text.toString(),
                        value1_6 = edValue16.text.toString(),
                        value1_7 = edValue17.text.toString(),
                        value1_8 = edValue18.text.toString(),
                        value1_9 = edValue19.text.toString(),
                        value1_10 = edValue110.text.toString(),
                        value2_1 = edValue21.text.toString(),
                        value2_2 = edValue22.text.toString(),
                        value2_3 = edValue23.text.toString(),
                        value2_4 = edValue24.text.toString(),
                        value2_5 = edValue25.text.toString(),
                        value2_6 = edValue26.text.toString(),
                        value2_7 = edValue27.text.toString(),
                        value2_8 = edValue28.text.toString(),
                        value2_9 = edValue29.text.toString(),
                        value2_10 = edValue210.text.toString(),

                    ))

                }
                dialog?.dismiss()
            }

        }

        dialog = builder.create()
        dialog?.window?.setSoftInputMode(SOFT_INPUT_STATE_VISIBLE)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }

    interface Listener{
        fun onClick(exerciseItem: ExerciseItem)
    }
}