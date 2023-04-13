package com.github.mishkaff89.fitnessnote.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mishkaff89.fitnessnote.R
import com.github.mishkaff89.fitnessnote.adapters.ExerciseAdapter
import com.github.mishkaff89.fitnessnote.database.MainViewModel
import com.github.mishkaff89.fitnessnote.databinding.ActivityTrainingBinding
import com.github.mishkaff89.fitnessnote.dialogs.*
import com.github.mishkaff89.fitnessnote.entity.ExerciseItem
import com.github.mishkaff89.fitnessnote.entity.TrainingItem
import com.github.mishkaff89.fitnessnote.utils.ShareHelper
import com.github.mishkaff89.fitnessnote.utils.TimeManager

class TrainingActivity : AppCompatActivity(), ExerciseAdapter.Listener {
    lateinit var binding: ActivityTrainingBinding
    private var trainingItem: TrainingItem? = null
    lateinit var adapter: ExerciseAdapter
    private lateinit var animation: Animation

    private val mainViewModel: MainViewModel by viewModels{
        MainViewModel.MainViewModelFactory((applicationContext as MainApp).database)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrainingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        supportActionBar?.title = trainingItem?.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        rcView()
        listItemObserver()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding.apply {
            animation = AnimationUtils.loadAnimation(this@TrainingActivity, R.anim.button_anim)
            flAddButton.setOnClickListener {
                flAddButton.hide()
                flCloseButton.startAnimation(animation)
                flCloseButton.show()
                flCardioButton.show()
                flGymButton.show()
            }
            flCloseButton.setOnClickListener {
                flCloseButton.hide()
                flCardioButton.hide()
                flGymButton.hide()
                flAddButton.show()
            }
            flCardioButton.setOnClickListener {
                startCardio(trainingItem!!)
                flCloseButton.hide()
                flCardioButton.hide()
                flGymButton.hide()
                flAddButton.show()
            }
            flGymButton.setOnClickListener {

                startGym(trainingItem!!)
                flCloseButton.hide()
                flCardioButton.hide()
                flGymButton.hide()
                flAddButton.show()
            }
        }
    }

    private fun startCardio(trainingItem: TrainingItem) {
        val i = Intent(this, CardioActivity::class.java).apply {
            putExtra(CardioActivity.TRAINING_ITEM_NAME, trainingItem)

        }
        startActivity(i)
    }

    private fun startGym(trainingItem: TrainingItem) {
        val i = Intent(this, GymActivity::class.java).apply {
            putExtra(GymActivity.TRAINING_ITEM_NAME, trainingItem)

        }
        startActivity(i)
    }

    private fun listItemObserver(){
        mainViewModel.getAllExerciseWithTraining(trainingItem?.id!!).observe(this){
            adapter.submitList(it.asReversed())
            binding.tvEmptyTraining.visibility = if (it.isEmpty()){
                View.VISIBLE
            } else {
                View.GONE
            }


        }
    }


        private fun init(){
        trainingItem = intent.getSerializableExtra(TRAINING_ITEM_NAME) as TrainingItem
    }
    private fun rcView() = with(binding){
        rcViewExe.layoutManager = LinearLayoutManager(this@TrainingActivity)
        adapter = ExerciseAdapter(this@TrainingActivity)
        adapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver(){
            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                (rcViewExe.layoutManager as LinearLayoutManager).scrollToPositionWithOffset(positionStart, 0)
            }
        })
        rcViewExe.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.training_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
            R.id.share_list -> {
                startActivity(
                    Intent.createChooser(
                    ShareHelper.shareShopList(adapter.currentList, trainingItem?.name!!, trainingItem?.time!!),
                    "Share by"
                ))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object{
        const val TRAINING_ITEM_NAME = "training_item"
    }

    override fun deleteItem(id: Int) {
        DeleteDialog.showDialog(this ,object : DeleteDialog.Listener{
            override fun onClick() {
                mainViewModel.deleteExercise(id)
            }
        })
    }

    override fun updateItem(exerciseItem: ExerciseItem) {
        if(exerciseItem.type == 1){
            UpdateCardioDialog.showDialog(this, exerciseItem ,object : UpdateCardioDialog.Listener{
                override fun onClick(exerciseItem: ExerciseItem) {
                    mainViewModel.updateExercise(exerciseItem)

                }
            })
        } else {
            UpdateExerciseDialog.showDialog(this,exerciseItem, object : UpdateExerciseDialog.Listener{
                override fun onClick(exerciseItem: ExerciseItem) {
                    mainViewModel.updateExercise(exerciseItem)
                }
            })
        }
    }

}