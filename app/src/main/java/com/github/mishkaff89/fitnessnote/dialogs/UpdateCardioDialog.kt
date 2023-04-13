package com.github.mishkaff89.fitnessnote.dialogs

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
import com.github.mishkaff89.fitnessnote.databinding.EditCardioDialogBinding
import com.github.mishkaff89.fitnessnote.entity.ExerciseItem

object UpdateCardioDialog {
    fun showDialog(context: Context,exerciseItem: ExerciseItem, listener: Listener){
        var dialog: AlertDialog? = null
        val builder = AlertDialog.Builder(context)
        val binding = EditCardioDialogBinding.inflate(LayoutInflater.from(context))
        builder.setView(binding.root)
        binding.apply {
            edNameCardio.setText(exerciseItem.name)
            edNameCardio.requestFocus()
            edTime.setText(exerciseItem.value1_1)
            edDist.setText(exerciseItem.value2_1)

            bSaveCardio.setOnClickListener {

                if (edNameCardio.text.toString().isNotEmpty()){
                    listener.onClick(exerciseItem.copy(
                        name = edNameCardio.text.toString(),
                        value1_1 = edTime.text.toString(),
                        value2_1 = edDist.text.toString()
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