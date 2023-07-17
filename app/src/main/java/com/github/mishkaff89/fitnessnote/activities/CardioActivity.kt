package com.github.mishkaff89.fitnessnote.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import com.github.mishkaff89.fitnessnote.R
import com.github.mishkaff89.fitnessnote.database.MainViewModel
import com.github.mishkaff89.fitnessnote.databinding.ActivityCardioBinding
import com.github.mishkaff89.fitnessnote.entity.ExerciseItem
import com.github.mishkaff89.fitnessnote.entity.TrainingItem
import com.github.mishkaff89.fitnessnote.utils.TimeManager

class CardioActivity : AppCompatActivity() {
    lateinit var binding: ActivityCardioBinding
    private var trainingItem: TrainingItem? = null

    private val mainViewModel: MainViewModel by viewModels{
        MainViewModel.MainViewModelFactory((applicationContext as MainApp).database)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Новое упражнение"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        binding.edCardioName.requestFocus()
        window?.setSoftInputMode(SOFT_INPUT_STATE_VISIBLE)
        mainViewModel.allLibraryItems.observe(this){item ->
            item?.let {
                val arr = mutableListOf<String>()

                for (value in it){
                    arr.add(value.name)
                }
                val adapter: ArrayAdapter<String> = ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, arr)
                binding.edCardioName.setAdapter(adapter)
                binding.edCardioName.threshold = 0
            }

        }
        init()
        addCardio()
    }

    private fun init(){
        trainingItem = intent.getSerializableExtra(TRAINING_ITEM_NAME) as TrainingItem
    }

    companion object{
        const val TRAINING_ITEM_NAME = "training_item"
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addCardio() = with(binding){
        bSaveCardio.setOnClickListener {
            val name = edCardioName.text.toString().replaceFirstChar { it.uppercase() }
            val time = editTextTime.text.toString()
            val dist = editTextDist.text.toString()

            if (name.isEmpty()) edCardioName.setBackgroundResource(R.color.bg_warning)
            if (time.isEmpty()) editTextTime.setBackgroundResource(R.color.bg_warning)
            if (dist.isEmpty()) editTextDist.setBackgroundResource(R.color.bg_warning)

            if (name.isNotEmpty() && time.isNotEmpty() && dist.isNotEmpty()){
                val item = ExerciseItem(
                    null,
                    name,
                    1,
                    trainingItem?.id!!, TimeManager.getTimeExercise(),
                    time,"","","","","",
                    "","","","",
                    dist,"","","","","",
                    "","","","")
                binding.apply {
                    mainViewModel.insertExercise(
                        item
                    )
                }
            }
            finish()
        }
    }






}