package com.github.mishkaff89.fitnessnote.dialogs

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import com.github.mishkaff89.fitnessnote.databinding.EditCardioDialogBinding
import com.github.mishkaff89.fitnessnote.databinding.UpdateLibraryBinding
import com.github.mishkaff89.fitnessnote.entity.ExerciseItem
import com.github.mishkaff89.fitnessnote.entity.LibraryItem

object UpdateLibraryDialog {
    fun showDialog(context: Context, libraryItem: LibraryItem, listener: Listener){
        var dialog: AlertDialog? = null
        val builder = AlertDialog.Builder(context)
        val binding = UpdateLibraryBinding.inflate(LayoutInflater.from(context))
        builder.setView(binding.root)
        binding.apply {
            edUpdateLibrary.setText(libraryItem.name)
            edUpdateLibrary.requestFocus()

            bSave.setOnClickListener {

                if (edUpdateLibrary.text.toString().isNotEmpty()){
                    listener.onClick(libraryItem.copy(
                        name = edUpdateLibrary.text.toString().replaceFirstChar { it.uppercase() }
                    ))

                }
                dialog?.dismiss()
            }

        }

        dialog = builder.create()
        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }

    interface Listener{
        fun onClick(libraryItem: LibraryItem)
    }
}