package com.github.mishkaff89.fitnessnote.dialogs

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
import android.widget.Toast
import com.github.mishkaff89.fitnessnote.R
import com.github.mishkaff89.fitnessnote.activities.TrainingActivity
import com.github.mishkaff89.fitnessnote.databinding.CardioDialogBinding
import com.github.mishkaff89.fitnessnote.entity.ExerciseItem

object CardioDialog {


    fun showDialog(context: Context,listener: Listener){
        var dialog: AlertDialog? = null
        val builder = AlertDialog.Builder(context)
        val binding = CardioDialogBinding.inflate(LayoutInflater.from(context))
        builder.setView(binding.root)
        binding.apply {
            edNameCardio.requestFocus()
            bSaveCardio.setOnClickListener {

                val name = edNameCardio.text.toString().replaceFirstChar { it.uppercase() }
                val time = edTime.text.toString()
                val dist = edDist.text.toString()

                if (name.isEmpty()) edNameCardio.setBackgroundResource(R.color.bg_warning)
                if (time.isEmpty()) edTime.setBackgroundResource(R.color.bg_warning)
                if (dist.isEmpty()) edDist.setBackgroundResource(R.color.bg_warning)

                if (name.isNotEmpty() && time.isNotEmpty() && dist.isNotEmpty()){
                    listener.onClick(name,time,dist)
                    dialog?.dismiss()
                }

            }

        }

        dialog = builder.create()
        dialog?.window?.setSoftInputMode(SOFT_INPUT_STATE_VISIBLE)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }

    interface Listener{
        fun onClick(name: String, time: String, dist: String)
    }
}