package com.github.mishkaff89.fitnessnote.dialogs

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
import com.github.mishkaff89.fitnessnote.R

import com.github.mishkaff89.fitnessnote.databinding.ExerciseDialogBinding
import com.github.mishkaff89.fitnessnote.utils.TimeManager

object ExerciseDialog {
    fun showDialog(context: Context, listener: Listener) {
        var dialog: AlertDialog? = null
        val builder = AlertDialog.Builder(context)
        val binding = ExerciseDialogBinding.inflate(LayoutInflater.from(context))
        builder.setView(binding.root)
        binding.apply {
            edNameExe.requestFocus()
            imOpenValue12.setOnClickListener {
                imOpenValue12.visibility = View.GONE
                imOpenValue23.visibility = View.VISIBLE
                imCloseValue21.visibility = View.VISIBLE
                cardView12.visibility = View.VISIBLE
                cardView22.visibility = View.VISIBLE
            }
            imOpenValue23.setOnClickListener {
                imOpenValue23.visibility = View.GONE
                imCloseValue21.visibility = View.GONE
                imOpenValue34.visibility = View.VISIBLE
                imCloseValue32.visibility = View.VISIBLE
                cardView23.visibility = View.VISIBLE
                cardView13.visibility = View.VISIBLE
            }
            imOpenValue34.setOnClickListener {
                imOpenValue34.visibility = View.GONE
                imCloseValue32.visibility = View.GONE
                imOpenValue45.visibility = View.VISIBLE
                imCloseValue43.visibility = View.VISIBLE
                cardView14.visibility = View.VISIBLE
                cardView24.visibility = View.VISIBLE
            }
            imOpenValue45.setOnClickListener {
                imOpenValue45.visibility = View.GONE
                imCloseValue43.visibility = View.GONE
                imOpenValue56.visibility = View.VISIBLE
                imCloseValue54.visibility = View.VISIBLE
                cardView15.visibility = View.VISIBLE
                cardView25.visibility = View.VISIBLE
            }
            imOpenValue56.setOnClickListener {
                imOpenValue56.visibility = View.GONE
                imCloseValue54.visibility = View.GONE
                imOpenValue67.visibility = View.VISIBLE
                imCloseValue65.visibility = View.VISIBLE
                cardView16.visibility = View.VISIBLE
                cardView26.visibility = View.VISIBLE
            }
            imOpenValue67.setOnClickListener {
                imOpenValue67.visibility = View.GONE
                imCloseValue65.visibility = View.GONE
                imOpenValue78.visibility = View.VISIBLE
                imCloseValue76.visibility = View.VISIBLE
                cardView17.visibility = View.VISIBLE
                cardView27.visibility = View.VISIBLE
            }
            imOpenValue78.setOnClickListener {
                imOpenValue78.visibility = View.GONE
                imCloseValue76.visibility = View.GONE
                imOpenValue89.visibility = View.VISIBLE
                imCloseValue87.visibility = View.VISIBLE
                cardView18.visibility = View.VISIBLE
                cardView28.visibility = View.VISIBLE
            }
            imOpenValue89.setOnClickListener {
                imOpenValue89.visibility = View.GONE
                imCloseValue87.visibility = View.GONE
                imOpenValue910.visibility = View.VISIBLE
                imCloseValue98.visibility = View.VISIBLE
                cardView19.visibility = View.VISIBLE
                cardView29.visibility = View.VISIBLE
            }
            imOpenValue910.setOnClickListener {
                imOpenValue910.visibility = View.GONE
                imCloseValue98.visibility = View.GONE
                imAllCloseValue.visibility = View.VISIBLE
                imCloseValue109.visibility = View.VISIBLE
                cardView110.visibility = View.VISIBLE
                cardView210.visibility = View.VISIBLE
            }
            imCloseValue21.setOnClickListener {
                imOpenValue23.visibility = View.GONE
                imCloseValue21.visibility = View.GONE
                imOpenValue12.visibility = View.VISIBLE
                cardView22.visibility = View.GONE
                cardView12.visibility = View.GONE
            }
            imCloseValue32.setOnClickListener {
                imOpenValue34.visibility = View.GONE
                imCloseValue32.visibility = View.GONE
                imOpenValue23.visibility = View.VISIBLE
                imCloseValue21.visibility = View.VISIBLE
                cardView23.visibility = View.GONE
                cardView13.visibility = View.GONE
            }
            imCloseValue43.setOnClickListener {
                imOpenValue45.visibility = View.GONE
                imCloseValue43.visibility = View.GONE
                imOpenValue34.visibility = View.VISIBLE
                imCloseValue32.visibility = View.VISIBLE
                cardView24.visibility = View.GONE
                cardView14.visibility = View.GONE
            }
            imCloseValue54.setOnClickListener {
                imOpenValue56.visibility = View.GONE
                imCloseValue54.visibility = View.GONE
                imOpenValue45.visibility = View.VISIBLE
                imCloseValue43.visibility = View.VISIBLE
                cardView25.visibility = View.GONE
                cardView15.visibility = View.GONE
            }
            imCloseValue65.setOnClickListener {
                imOpenValue67.visibility = View.GONE
                imCloseValue65.visibility = View.GONE
                imOpenValue56.visibility = View.VISIBLE
                imCloseValue54.visibility = View.VISIBLE
                cardView26.visibility = View.GONE
                cardView16.visibility = View.GONE
            }
            imCloseValue76.setOnClickListener {
                imOpenValue78.visibility = View.GONE
                imCloseValue76.visibility = View.GONE
                imOpenValue67.visibility = View.VISIBLE
                imCloseValue65.visibility = View.VISIBLE
                cardView27.visibility = View.GONE
                cardView17.visibility = View.GONE
            }
            imCloseValue87.setOnClickListener {
                imOpenValue89.visibility = View.GONE
                imCloseValue87.visibility = View.GONE
                imOpenValue78.visibility = View.VISIBLE
                imCloseValue76.visibility = View.VISIBLE
                cardView28.visibility = View.GONE
                cardView18.visibility = View.GONE
            }
            imCloseValue98.setOnClickListener {
                imOpenValue910.visibility = View.GONE
                imCloseValue98.visibility = View.GONE
                imOpenValue89.visibility = View.VISIBLE
                imCloseValue87.visibility = View.VISIBLE
                cardView29.visibility = View.GONE
                cardView19.visibility = View.GONE
            }
            imCloseValue109.setOnClickListener {
                imAllCloseValue.visibility = View.GONE
                imCloseValue109.visibility = View.GONE
                imOpenValue910.visibility = View.VISIBLE
                imCloseValue98.visibility = View.VISIBLE
                cardView210.visibility = View.GONE
                cardView110.visibility = View.GONE
            }
            imAllCloseValue.setOnClickListener {
                imAllCloseValue.visibility = View.GONE
                imCloseValue109.visibility = View.GONE
                imOpenValue12.visibility = View.VISIBLE
                cardView22.visibility = View.GONE
                cardView12.visibility = View.GONE
                cardView23.visibility = View.GONE
                cardView13.visibility = View.GONE
                cardView24.visibility = View.GONE
                cardView14.visibility = View.GONE
                cardView25.visibility = View.GONE
                cardView15.visibility = View.GONE
                cardView26.visibility = View.GONE
                cardView16.visibility = View.GONE
                cardView27.visibility = View.GONE
                cardView17.visibility = View.GONE
                cardView28.visibility = View.GONE
                cardView18.visibility = View.GONE
                cardView29.visibility = View.GONE
                cardView19.visibility = View.GONE
                cardView210.visibility = View.GONE
                cardView110.visibility = View.GONE
            }



            bSaveExe.setOnClickListener {
                val name = edNameExe.text.toString().replaceFirstChar { it.uppercase() }

                val value_1_1 = edValue11.text.toString()
                val value_1_2 = edValue12.text.toString()
                val value_1_3 = edValue13.text.toString()
                val value_1_4 = edValue14.text.toString()
                val value_1_5 = edValue15.text.toString()
                val value_1_6 = edValue16.text.toString()
                val value_1_7 = edValue17.text.toString()
                val value_1_8 = edValue18.text.toString()
                val value_1_9 = edValue19.text.toString()
                val value_1_10 = edValue110.text.toString()

                val value_2_1 = edValue21.text.toString()
                val value_2_2 = edValue22.text.toString()
                val value_2_3 = edValue23.text.toString()
                val value_2_4 = edValue24.text.toString()
                val value_2_5 = edValue25.text.toString()
                val value_2_6 = edValue26.text.toString()
                val value_2_7 = edValue27.text.toString()
                val value_2_8 = edValue28.text.toString()
                val value_2_9 = edValue29.text.toString()
                val value_2_10 = edValue210.text.toString()

                if (name.isNotEmpty() && value_1_1.isNotEmpty() && value_2_1.isNotEmpty()) {
                    listener.onClick(
                        name, value_1_1, value_1_2, value_1_3, value_1_4, value_1_5,
                        value_1_6, value_1_7, value_1_8, value_1_9, value_1_10, value_2_1,
                        value_2_2, value_2_3, value_2_4, value_2_5, value_2_6, value_2_7,
                        value_2_8, value_2_9, value_2_10
                    )
                    dialog?.dismiss()
                }
            }

        }

        dialog = builder.create()
        dialog?.window?.setSoftInputMode(SOFT_INPUT_STATE_VISIBLE)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }

    interface Listener {
        fun onClick(
            name: String, value_1_1: String, value_1_2: String, value_1_3: String,
            value_1_4: String, value_1_5: String, value_1_6: String, value_1_7: String,
            value_1_8: String, value_1_9: String, value_1_10: String,
            value_2_1: String, value_2_2: String, value_2_3: String,
            value_2_4: String, value_2_5: String, value_2_6: String, value_2_7: String,
            value_2_8: String, value_2_9: String, value_2_10: String,
        )
    }
}