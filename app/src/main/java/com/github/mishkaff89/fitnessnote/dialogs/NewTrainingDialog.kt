package com.github.mishkaff89.fitnessnote.dialogs

import android.app.AlertDialog
import android.content.Context
import android.provider.SyncStateContract.Helpers.update
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT
import android.view.WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
import android.view.inputmethod.InputMethodManager
import com.github.mishkaff89.fitnessnote.R
import com.github.mishkaff89.fitnessnote.databinding.NewTrainingDialogBinding

object NewTrainingDialog {
    fun showDialog(context: Context, listener: Listener, name: String){
        var dialog: AlertDialog? = null
        val builder = AlertDialog.Builder(context)
        val binding = NewTrainingDialogBinding.inflate(LayoutInflater.from(context))
        builder.setView(binding.root)
        binding.apply {
            edNewTraining.setText(name)
            edNewTraining.requestFocus()

            if (name.isNotEmpty()) {
                tvNameTraining.setText(R.string.update_training)
                bSaveTraining.setText(R.string.update)
            }
            bSaveTraining.setOnClickListener {
                val trainingName = edNewTraining.text.toString().replaceFirstChar { it.uppercase() }
                if (edNewTraining.text.toString().isEmpty()) {
                    edNewTraining.setBackgroundResource(R.color.bg_warning)
                }
                if (trainingName.isNotEmpty()){
                listener.onClick(trainingName)
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
        fun onClick(name: String)
    }
}