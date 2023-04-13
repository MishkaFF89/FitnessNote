package com.github.mishkaff89.fitnessnote.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.github.mishkaff89.fitnessnote.R
import com.github.mishkaff89.fitnessnote.database.MainViewModel
import com.github.mishkaff89.fitnessnote.databinding.ActivityGymBinding
import com.github.mishkaff89.fitnessnote.entity.ExerciseItem
import com.github.mishkaff89.fitnessnote.entity.TrainingItem
import com.github.mishkaff89.fitnessnote.utils.TimeManager

class GymActivity : AppCompatActivity() {
    lateinit var binding: ActivityGymBinding
    private var trainingItem: TrainingItem? = null
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModel.MainViewModelFactory((applicationContext as MainApp).database)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGymBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        supportActionBar?.title = "Новое упражнение"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        buttonExe()
        addGymExe()
        binding.edNameGym.requestFocus()
        window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)

        mainViewModel.allLibraryItems.observe(this){item ->
            item?.let {
                val arr = mutableListOf<String>()

                for (value in it){
                    arr.add(value.name)

                }
                val adapter: ArrayAdapter<String> = ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, arr)
                binding.edNameGym.setAdapter(adapter)
                binding.edNameGym.threshold = 0
            }

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun buttonExe() = with(binding) {

        addValues2.setOnClickListener {
            addValues2.visibility = View.GONE
            addValues3.visibility = View.VISIBLE
            closeValues1.visibility = View.VISIBLE
            editTextV22.visibility = View.VISIBLE
            editTextV12.visibility = View.VISIBLE
        }
        addValues3.setOnClickListener {
            addValues3.visibility = View.GONE
            closeValues1.visibility = View.GONE
            addValues4.visibility = View.VISIBLE
            closeValues2.visibility = View.VISIBLE
            editTextV23.visibility = View.VISIBLE
            editTextV13.visibility = View.VISIBLE
        }
        addValues4.setOnClickListener {
            addValues4.visibility = View.GONE
            closeValues2.visibility = View.GONE
            addValues5.visibility = View.VISIBLE
            closeValues3.visibility = View.VISIBLE
            editTextV24.visibility = View.VISIBLE
            editTextV14.visibility = View.VISIBLE
        }
        addValues5.setOnClickListener {
            addValues5.visibility = View.GONE
            closeValues3.visibility = View.GONE
            addValues6.visibility = View.VISIBLE
            closeValues4.visibility = View.VISIBLE
            editTextV25.visibility = View.VISIBLE
            editTextV15.visibility = View.VISIBLE
        }
        addValues6.setOnClickListener {
            addValues6.visibility = View.GONE
            closeValues4.visibility = View.GONE
            addValues7.visibility = View.VISIBLE
            closeValues5.visibility = View.VISIBLE
            editTextV26.visibility = View.VISIBLE
            editTextV16.visibility = View.VISIBLE
        }
        addValues7.setOnClickListener {
            addValues7.visibility = View.GONE
            closeValues5.visibility = View.GONE
            addValues8.visibility = View.VISIBLE
            closeValues6.visibility = View.VISIBLE
            editTextV27.visibility = View.VISIBLE
            editTextV17.visibility = View.VISIBLE
        }
        addValues8.setOnClickListener {
            addValues8.visibility = View.GONE
            closeValues6.visibility = View.GONE
            addValues9.visibility = View.VISIBLE
            closeValues7.visibility = View.VISIBLE
            editTextV28.visibility = View.VISIBLE
            editTextV18.visibility = View.VISIBLE
        }
        addValues9.setOnClickListener {
            addValues9.visibility = View.GONE
            closeValues7.visibility = View.GONE
            addValues10.visibility = View.VISIBLE
            closeValues8.visibility = View.VISIBLE
            editTextV29.visibility = View.VISIBLE
            editTextV19.visibility = View.VISIBLE
        }
        addValues10.setOnClickListener {
            addValues10.visibility = View.GONE
            closeValues8.visibility = View.GONE
            imAllClose.visibility = View.VISIBLE
            closeValues9.visibility = View.VISIBLE
            editTextV210.visibility = View.VISIBLE
            editTextV110.visibility = View.VISIBLE
        }

        closeValues1.setOnClickListener {
            editTextV12.text.clear()
            editTextV22.text.clear()
            editTextV12.visibility = View.GONE
            editTextV22.visibility = View.GONE
            closeValues1.visibility = View.GONE
            addValues3.visibility = View.GONE
            addValues2.visibility = View.VISIBLE
        }
        closeValues2.setOnClickListener {
            editTextV13.text.clear()
            editTextV23.text.clear()
            editTextV13.visibility = View.GONE
            editTextV23.visibility = View.GONE
            closeValues2.visibility = View.GONE
            addValues4.visibility = View.GONE
            addValues3.visibility = View.VISIBLE
            closeValues1.visibility = View.VISIBLE
        }
        closeValues3.setOnClickListener {
            editTextV14.text.clear()
            editTextV24.text.clear()
            editTextV14.visibility = View.GONE
            editTextV24.visibility = View.GONE
            closeValues3.visibility = View.GONE
            addValues5.visibility = View.GONE
            addValues4.visibility = View.VISIBLE
            closeValues2.visibility = View.VISIBLE
        }
        closeValues4.setOnClickListener {
            editTextV15.text.clear()
            editTextV25.text.clear()
            editTextV15.visibility = View.GONE
            editTextV25.visibility = View.GONE
            closeValues4.visibility = View.GONE
            addValues6.visibility = View.GONE
            addValues5.visibility = View.VISIBLE
            closeValues3.visibility = View.VISIBLE
        }
        closeValues5.setOnClickListener {
            editTextV16.text.clear()
            editTextV26.text.clear()
            editTextV16.visibility = View.GONE
            editTextV26.visibility = View.GONE
            closeValues5.visibility = View.GONE
            addValues7.visibility = View.GONE
            addValues6.visibility = View.VISIBLE
            closeValues4.visibility = View.VISIBLE
        }
        closeValues6.setOnClickListener {
            editTextV17.text.clear()
            editTextV27.text.clear()
            editTextV17.visibility = View.GONE
            editTextV27.visibility = View.GONE
            closeValues6.visibility = View.GONE
            addValues8.visibility = View.GONE
            addValues7.visibility = View.VISIBLE
            closeValues5.visibility = View.VISIBLE
        }
        closeValues7.setOnClickListener {
            editTextV18.text.clear()
            editTextV28.text.clear()
            editTextV18.visibility = View.GONE
            editTextV28.visibility = View.GONE
            closeValues7.visibility = View.GONE
            addValues9.visibility = View.GONE
            addValues8.visibility = View.VISIBLE
            closeValues6.visibility = View.VISIBLE
        }
        closeValues8.setOnClickListener {
            editTextV19.text.clear()
            editTextV29.text.clear()
            editTextV19.visibility = View.GONE
            editTextV29.visibility = View.GONE
            closeValues8.visibility = View.GONE
            addValues10.visibility = View.GONE
            addValues9.visibility = View.VISIBLE
            closeValues7.visibility = View.VISIBLE
        }
        closeValues9.setOnClickListener {
            editTextV110.text.clear()
            editTextV210.text.clear()
            editTextV110.visibility = View.GONE
            editTextV210.visibility = View.GONE
            closeValues9.visibility = View.GONE
            addValues10.visibility = View.VISIBLE
            closeValues8.visibility = View.VISIBLE
            imAllClose.visibility = View.GONE
        }
        imAllClose.setOnClickListener {
            imAllClose.visibility = View.GONE
            closeValues9.visibility = View.GONE
            addValues2.visibility = View.VISIBLE
            editTextV110.text.clear()
            editTextV210.text.clear()
            editTextV19.text.clear()
            editTextV29.text.clear()
            editTextV18.text.clear()
            editTextV28.text.clear()
            editTextV17.text.clear()
            editTextV27.text.clear()
            editTextV16.text.clear()
            editTextV26.text.clear()
            editTextV15.text.clear()
            editTextV25.text.clear()
            editTextV14.text.clear()
            editTextV24.text.clear()
            editTextV13.text.clear()
            editTextV23.text.clear()
            editTextV12.text.clear()
            editTextV22.text.clear()

            editTextV110.visibility = View.GONE
            editTextV210.visibility = View.GONE
            editTextV19.visibility = View.GONE
            editTextV29.visibility = View.GONE
            editTextV18.visibility = View.GONE
            editTextV28.visibility = View.GONE
            editTextV17.visibility = View.GONE
            editTextV27.visibility = View.GONE
            editTextV16.visibility = View.GONE
            editTextV26.visibility = View.GONE
            editTextV15.visibility = View.GONE
            editTextV25.visibility = View.GONE
            editTextV14.visibility = View.GONE
            editTextV24.visibility = View.GONE
            editTextV13.visibility = View.GONE
            editTextV23.visibility = View.GONE
            editTextV12.visibility = View.GONE
            editTextV22.visibility = View.GONE

        }


    }

    private fun addGymExe() = with(binding) {
        bSaveExe.setOnClickListener {
            val name = edNameGym.text.toString().replaceFirstChar { it.uppercase() }

            val value_1_1 = editTextV11.text.toString()
            val value_1_2 = editTextV12.text.toString()
            val value_1_3 = editTextV13.text.toString()
            val value_1_4 = editTextV14.text.toString()
            val value_1_5 = editTextV15.text.toString()
            val value_1_6 = editTextV16.text.toString()
            val value_1_7 = editTextV17.text.toString()
            val value_1_8 = editTextV18.text.toString()
            val value_1_9 = editTextV19.text.toString()
            val value_1_10 = editTextV110.text.toString()

            val value_2_1 = editTextV21.text.toString()
            val value_2_2 = editTextV22.text.toString()
            val value_2_3 = editTextV23.text.toString()
            val value_2_4 = editTextV24.text.toString()
            val value_2_5 = editTextV25.text.toString()
            val value_2_6 = editTextV26.text.toString()
            val value_2_7 = editTextV27.text.toString()
            val value_2_8 = editTextV28.text.toString()
            val value_2_9 = editTextV29.text.toString()
            val value_2_10 = editTextV210.text.toString()


            if (edNameGym.text.isEmpty()) {
                edNameGym.setBackgroundResource(R.color.bg_warning)
            }
            when{
                addValues2.isVisible ->{
                    if (name.isNotEmpty() && value_1_1.isNotEmpty() && value_2_1.isNotEmpty()) {
                        val item = ExerciseItem(
                            null, name, 2, trainingItem?.id!!, TimeManager.getTimeExercise(),
                            value_1_1, value_1_2, value_1_3, value_1_4, value_1_5, value_1_6, value_1_7,
                            value_1_8, value_1_9, value_1_10, value_2_1, value_2_2, value_2_3,
                            value_2_4, value_2_5, value_2_6, value_2_7, value_2_8, value_2_9,
                            value_2_10
                        )
                        mainViewModel.insertExercise(item)
                        finish()
                    } else {
                        editTextV11.setBackgroundResource(R.color.bg_warning)
                        editTextV21.setBackgroundResource(R.color.bg_warning)
                    }
                }
                addValues3.isVisible ->{
                    if (name.isNotEmpty() && value_1_1.isNotEmpty() && value_2_1.isNotEmpty()
                        && value_1_2.isNotEmpty() && value_2_2.isNotEmpty()) {
                        val item = ExerciseItem(
                            null, name, 2, trainingItem?.id!!, TimeManager.getTimeExercise(),
                            value_1_1, value_1_2, value_1_3, value_1_4, value_1_5, value_1_6, value_1_7,
                            value_1_8, value_1_9, value_1_10, value_2_1, value_2_2, value_2_3,
                            value_2_4, value_2_5, value_2_6, value_2_7, value_2_8, value_2_9,
                            value_2_10
                        )
                        mainViewModel.insertExercise(item)
                        finish()
                    } else {
                        editTextV12.setBackgroundResource(R.color.bg_warning)
                        editTextV22.setBackgroundResource(R.color.bg_warning)
                        editTextV11.setBackgroundResource(R.color.bg_warning)
                        editTextV21.setBackgroundResource(R.color.bg_warning)
                    }
                }
                addValues4.isVisible ->{
                    if (name.isNotEmpty() && value_1_1.isNotEmpty() && value_2_1.isNotEmpty()
                        && value_1_2.isNotEmpty() && value_2_2.isNotEmpty()
                        && value_1_3.isNotEmpty() && value_2_3.isNotEmpty()) {
                        val item = ExerciseItem(
                            null, name, 2, trainingItem?.id!!, TimeManager.getTimeExercise(),
                            value_1_1, value_1_2, value_1_3, value_1_4, value_1_5, value_1_6, value_1_7,
                            value_1_8, value_1_9, value_1_10, value_2_1, value_2_2, value_2_3,
                            value_2_4, value_2_5, value_2_6, value_2_7, value_2_8, value_2_9,
                            value_2_10
                        )
                        mainViewModel.insertExercise(item)
                        finish()
                    } else {
                        editTextV13.setBackgroundResource(R.color.bg_warning)
                        editTextV23.setBackgroundResource(R.color.bg_warning)
                        editTextV12.setBackgroundResource(R.color.bg_warning)
                        editTextV22.setBackgroundResource(R.color.bg_warning)
                        editTextV11.setBackgroundResource(R.color.bg_warning)
                        editTextV21.setBackgroundResource(R.color.bg_warning)
                    }
                }
                addValues5.isVisible ->{
                    if (name.isNotEmpty() && value_1_1.isNotEmpty() && value_2_1.isNotEmpty()
                        && value_1_2.isNotEmpty() && value_2_2.isNotEmpty()
                        && value_1_3.isNotEmpty() && value_2_3.isNotEmpty()
                        && value_1_4.isNotEmpty() && value_2_4.isNotEmpty()) {
                        val item = ExerciseItem(
                            null, name, 2, trainingItem?.id!!, TimeManager.getTimeExercise(),
                            value_1_1, value_1_2, value_1_3, value_1_4, value_1_5, value_1_6, value_1_7,
                            value_1_8, value_1_9, value_1_10, value_2_1, value_2_2, value_2_3,
                            value_2_4, value_2_5, value_2_6, value_2_7, value_2_8, value_2_9,
                            value_2_10
                        )
                        mainViewModel.insertExercise(item)
                        finish()
                    } else {
                        editTextV14.setBackgroundResource(R.color.bg_warning)
                        editTextV24.setBackgroundResource(R.color.bg_warning)
                        editTextV13.setBackgroundResource(R.color.bg_warning)
                        editTextV23.setBackgroundResource(R.color.bg_warning)
                        editTextV12.setBackgroundResource(R.color.bg_warning)
                        editTextV22.setBackgroundResource(R.color.bg_warning)
                        editTextV11.setBackgroundResource(R.color.bg_warning)
                        editTextV21.setBackgroundResource(R.color.bg_warning)
                    }

                }
                addValues6.isVisible ->{
                    if (name.isNotEmpty() && value_1_1.isNotEmpty() && value_2_1.isNotEmpty()
                        && value_1_2.isNotEmpty() && value_2_2.isNotEmpty()
                        && value_1_3.isNotEmpty() && value_2_3.isNotEmpty()
                        && value_1_4.isNotEmpty() && value_2_4.isNotEmpty()
                        && value_1_5.isNotEmpty() && value_2_5.isNotEmpty()) {
                        val item = ExerciseItem(
                            null, name, 2, trainingItem?.id!!, TimeManager.getTimeExercise(),
                            value_1_1, value_1_2, value_1_3, value_1_4, value_1_5, value_1_6, value_1_7,
                            value_1_8, value_1_9, value_1_10, value_2_1, value_2_2, value_2_3,
                            value_2_4, value_2_5, value_2_6, value_2_7, value_2_8, value_2_9,
                            value_2_10
                        )
                        mainViewModel.insertExercise(item)
                        finish()
                    } else {
                        editTextV15.setBackgroundResource(R.color.bg_warning)
                        editTextV25.setBackgroundResource(R.color.bg_warning)
                        editTextV14.setBackgroundResource(R.color.bg_warning)
                        editTextV24.setBackgroundResource(R.color.bg_warning)
                        editTextV13.setBackgroundResource(R.color.bg_warning)
                        editTextV23.setBackgroundResource(R.color.bg_warning)
                        editTextV12.setBackgroundResource(R.color.bg_warning)
                        editTextV22.setBackgroundResource(R.color.bg_warning)
                        editTextV11.setBackgroundResource(R.color.bg_warning)
                        editTextV21.setBackgroundResource(R.color.bg_warning)
                    }
                }
                addValues7.isVisible ->{
                    if (name.isNotEmpty() && value_1_1.isNotEmpty() && value_2_1.isNotEmpty()
                        && value_1_2.isNotEmpty() && value_2_2.isNotEmpty()
                        && value_1_3.isNotEmpty() && value_2_3.isNotEmpty()
                        && value_1_4.isNotEmpty() && value_2_4.isNotEmpty()
                        && value_1_5.isNotEmpty() && value_2_5.isNotEmpty()
                        && value_1_6.isNotEmpty() && value_2_6.isNotEmpty()) {
                        val item = ExerciseItem(
                            null, name, 2, trainingItem?.id!!, TimeManager.getTimeExercise(),
                            value_1_1, value_1_2, value_1_3, value_1_4, value_1_5, value_1_6, value_1_7,
                            value_1_8, value_1_9, value_1_10, value_2_1, value_2_2, value_2_3,
                            value_2_4, value_2_5, value_2_6, value_2_7, value_2_8, value_2_9,
                            value_2_10
                        )
                        mainViewModel.insertExercise(item)
                        finish()
                    } else {
                        editTextV16.setBackgroundResource(R.color.bg_warning)
                        editTextV26.setBackgroundResource(R.color.bg_warning)
                        editTextV15.setBackgroundResource(R.color.bg_warning)
                        editTextV25.setBackgroundResource(R.color.bg_warning)
                        editTextV14.setBackgroundResource(R.color.bg_warning)
                        editTextV24.setBackgroundResource(R.color.bg_warning)
                        editTextV13.setBackgroundResource(R.color.bg_warning)
                        editTextV23.setBackgroundResource(R.color.bg_warning)
                        editTextV12.setBackgroundResource(R.color.bg_warning)
                        editTextV22.setBackgroundResource(R.color.bg_warning)
                        editTextV11.setBackgroundResource(R.color.bg_warning)
                        editTextV21.setBackgroundResource(R.color.bg_warning)
                    }
                }
                addValues8.isVisible ->{
                    if (name.isNotEmpty() && value_1_1.isNotEmpty() && value_2_1.isNotEmpty()
                        && value_1_2.isNotEmpty() && value_2_2.isNotEmpty()
                        && value_1_3.isNotEmpty() && value_2_3.isNotEmpty()
                        && value_1_4.isNotEmpty() && value_2_4.isNotEmpty()
                        && value_1_5.isNotEmpty() && value_2_5.isNotEmpty()
                        && value_1_6.isNotEmpty() && value_2_6.isNotEmpty()
                        && value_1_7.isNotEmpty() && value_2_7.isNotEmpty()) {
                        val item = ExerciseItem(
                            null, name, 2, trainingItem?.id!!, TimeManager.getTimeExercise(),
                            value_1_1, value_1_2, value_1_3, value_1_4, value_1_5, value_1_6, value_1_7,
                            value_1_8, value_1_9, value_1_10, value_2_1, value_2_2, value_2_3,
                            value_2_4, value_2_5, value_2_6, value_2_7, value_2_8, value_2_9,
                            value_2_10
                        )
                        mainViewModel.insertExercise(item)
                        finish()
                    } else {
                        editTextV17.setBackgroundResource(R.color.bg_warning)
                        editTextV27.setBackgroundResource(R.color.bg_warning)
                        editTextV16.setBackgroundResource(R.color.bg_warning)
                        editTextV26.setBackgroundResource(R.color.bg_warning)
                        editTextV15.setBackgroundResource(R.color.bg_warning)
                        editTextV25.setBackgroundResource(R.color.bg_warning)
                        editTextV14.setBackgroundResource(R.color.bg_warning)
                        editTextV24.setBackgroundResource(R.color.bg_warning)
                        editTextV13.setBackgroundResource(R.color.bg_warning)
                        editTextV23.setBackgroundResource(R.color.bg_warning)
                        editTextV12.setBackgroundResource(R.color.bg_warning)
                        editTextV22.setBackgroundResource(R.color.bg_warning)
                        editTextV11.setBackgroundResource(R.color.bg_warning)
                        editTextV21.setBackgroundResource(R.color.bg_warning)
                    }
                }
                addValues9.isVisible ->{
                    if (name.isNotEmpty() && value_1_1.isNotEmpty() && value_2_1.isNotEmpty()
                        && value_1_2.isNotEmpty() && value_2_2.isNotEmpty()
                        && value_1_3.isNotEmpty() && value_2_3.isNotEmpty()
                        && value_1_4.isNotEmpty() && value_2_4.isNotEmpty()
                        && value_1_5.isNotEmpty() && value_2_5.isNotEmpty()
                        && value_1_6.isNotEmpty() && value_2_6.isNotEmpty()
                        && value_1_7.isNotEmpty() && value_2_7.isNotEmpty()
                        && value_1_8.isNotEmpty() && value_2_8.isNotEmpty()) {
                        val item = ExerciseItem(
                            null, name, 2, trainingItem?.id!!, TimeManager.getTimeExercise(),
                            value_1_1, value_1_2, value_1_3, value_1_4, value_1_5, value_1_6, value_1_7,
                            value_1_8, value_1_9, value_1_10, value_2_1, value_2_2, value_2_3,
                            value_2_4, value_2_5, value_2_6, value_2_7, value_2_8, value_2_9,
                            value_2_10
                        )
                        mainViewModel.insertExercise(item)
                        finish()
                    } else {
                        editTextV18.setBackgroundResource(R.color.bg_warning)
                        editTextV28.setBackgroundResource(R.color.bg_warning)
                        editTextV17.setBackgroundResource(R.color.bg_warning)
                        editTextV27.setBackgroundResource(R.color.bg_warning)
                        editTextV16.setBackgroundResource(R.color.bg_warning)
                        editTextV26.setBackgroundResource(R.color.bg_warning)
                        editTextV15.setBackgroundResource(R.color.bg_warning)
                        editTextV25.setBackgroundResource(R.color.bg_warning)
                        editTextV14.setBackgroundResource(R.color.bg_warning)
                        editTextV24.setBackgroundResource(R.color.bg_warning)
                        editTextV13.setBackgroundResource(R.color.bg_warning)
                        editTextV23.setBackgroundResource(R.color.bg_warning)
                        editTextV12.setBackgroundResource(R.color.bg_warning)
                        editTextV22.setBackgroundResource(R.color.bg_warning)
                        editTextV11.setBackgroundResource(R.color.bg_warning)
                        editTextV21.setBackgroundResource(R.color.bg_warning)
                    }
                }
                addValues10.isVisible ->{
                    if (name.isNotEmpty() && value_1_1.isNotEmpty() && value_2_1.isNotEmpty()
                        && value_1_2.isNotEmpty() && value_2_2.isNotEmpty()
                        && value_1_3.isNotEmpty() && value_2_3.isNotEmpty()
                        && value_1_4.isNotEmpty() && value_2_4.isNotEmpty()
                        && value_1_5.isNotEmpty() && value_2_5.isNotEmpty()
                        && value_1_6.isNotEmpty() && value_2_6.isNotEmpty()
                        && value_1_7.isNotEmpty() && value_2_7.isNotEmpty()
                        && value_1_8.isNotEmpty() && value_2_8.isNotEmpty()
                        && value_1_9.isNotEmpty() && value_2_9.isNotEmpty()) {
                        val item = ExerciseItem(
                            null, name, 2, trainingItem?.id!!, TimeManager.getTimeExercise(),
                            value_1_1, value_1_2, value_1_3, value_1_4, value_1_5, value_1_6, value_1_7,
                            value_1_8, value_1_9, value_1_10, value_2_1, value_2_2, value_2_3,
                            value_2_4, value_2_5, value_2_6, value_2_7, value_2_8, value_2_9,
                            value_2_10
                        )
                        mainViewModel.insertExercise(item)
                        finish()
                    } else {
                        editTextV19.setBackgroundResource(R.color.bg_warning)
                        editTextV29.setBackgroundResource(R.color.bg_warning)
                        editTextV18.setBackgroundResource(R.color.bg_warning)
                        editTextV28.setBackgroundResource(R.color.bg_warning)
                        editTextV17.setBackgroundResource(R.color.bg_warning)
                        editTextV27.setBackgroundResource(R.color.bg_warning)
                        editTextV16.setBackgroundResource(R.color.bg_warning)
                        editTextV26.setBackgroundResource(R.color.bg_warning)
                        editTextV15.setBackgroundResource(R.color.bg_warning)
                        editTextV25.setBackgroundResource(R.color.bg_warning)
                        editTextV14.setBackgroundResource(R.color.bg_warning)
                        editTextV24.setBackgroundResource(R.color.bg_warning)
                        editTextV13.setBackgroundResource(R.color.bg_warning)
                        editTextV23.setBackgroundResource(R.color.bg_warning)
                        editTextV12.setBackgroundResource(R.color.bg_warning)
                        editTextV22.setBackgroundResource(R.color.bg_warning)
                        editTextV11.setBackgroundResource(R.color.bg_warning)
                        editTextV21.setBackgroundResource(R.color.bg_warning)
                    }
                }
                imAllClose.isVisible ->{
                    if (name.isNotEmpty() && value_1_1.isNotEmpty() && value_2_1.isNotEmpty()
                        && value_1_2.isNotEmpty() && value_2_2.isNotEmpty()
                        && value_1_3.isNotEmpty() && value_2_3.isNotEmpty()
                        && value_1_4.isNotEmpty() && value_2_4.isNotEmpty()
                        && value_1_5.isNotEmpty() && value_2_5.isNotEmpty()
                        && value_1_6.isNotEmpty() && value_2_6.isNotEmpty()
                        && value_1_7.isNotEmpty() && value_2_7.isNotEmpty()
                        && value_1_8.isNotEmpty() && value_2_8.isNotEmpty()
                        && value_1_9.isNotEmpty() && value_2_9.isNotEmpty()
                        && value_1_10.isNotEmpty() && value_2_10.isNotEmpty()) {
                        val item = ExerciseItem(
                            null, name, 2, trainingItem?.id!!, TimeManager.getTimeExercise(),
                            value_1_1, value_1_2, value_1_3, value_1_4, value_1_5, value_1_6, value_1_7,
                            value_1_8, value_1_9, value_1_10, value_2_1, value_2_2, value_2_3,
                            value_2_4, value_2_5, value_2_6, value_2_7, value_2_8, value_2_9,
                            value_2_10
                        )
                        mainViewModel.insertExercise(item)
                        finish()
                    } else {
                        editTextV110.setBackgroundResource(R.color.bg_warning)
                        editTextV210.setBackgroundResource(R.color.bg_warning)
                        editTextV19.setBackgroundResource(R.color.bg_warning)
                        editTextV29.setBackgroundResource(R.color.bg_warning)
                        editTextV18.setBackgroundResource(R.color.bg_warning)
                        editTextV28.setBackgroundResource(R.color.bg_warning)
                        editTextV17.setBackgroundResource(R.color.bg_warning)
                        editTextV27.setBackgroundResource(R.color.bg_warning)
                        editTextV16.setBackgroundResource(R.color.bg_warning)
                        editTextV26.setBackgroundResource(R.color.bg_warning)
                        editTextV15.setBackgroundResource(R.color.bg_warning)
                        editTextV25.setBackgroundResource(R.color.bg_warning)
                        editTextV14.setBackgroundResource(R.color.bg_warning)
                        editTextV24.setBackgroundResource(R.color.bg_warning)
                        editTextV13.setBackgroundResource(R.color.bg_warning)
                        editTextV23.setBackgroundResource(R.color.bg_warning)
                        editTextV12.setBackgroundResource(R.color.bg_warning)
                        editTextV22.setBackgroundResource(R.color.bg_warning)
                        editTextV11.setBackgroundResource(R.color.bg_warning)
                        editTextV21.setBackgroundResource(R.color.bg_warning)
                    }
                }


            }





        }
    }

    private fun init() {
        trainingItem = intent.getSerializableExtra(TRAINING_ITEM_NAME) as TrainingItem
    }

    companion object {
        const val TRAINING_ITEM_NAME = "training_item"
    }

}