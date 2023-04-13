package com.github.mishkaff89.fitnessnote.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mishkaff89.fitnessnote.activities.CardioActivity
import com.github.mishkaff89.fitnessnote.activities.MainApp
import com.github.mishkaff89.fitnessnote.activities.TrainingActivity
import com.github.mishkaff89.fitnessnote.adapters.AdapterTraining
import com.github.mishkaff89.fitnessnote.database.MainViewModel
import com.github.mishkaff89.fitnessnote.databinding.FragmentHomeBinding
import com.github.mishkaff89.fitnessnote.dialogs.DeleteDialog
import com.github.mishkaff89.fitnessnote.dialogs.NewTrainingDialog
import com.github.mishkaff89.fitnessnote.entity.TrainingItem
import com.github.mishkaff89.fitnessnote.utils.TimeManager


class HomeFragment : BaseFragment(), AdapterTraining.Listener {
    lateinit var binding: FragmentHomeBinding
    lateinit var adapter: AdapterTraining

    private val mainViewModel: MainViewModel by activityViewModels{
        MainViewModel.MainViewModelFactory((context?.applicationContext as MainApp).database)
    }

    override fun onClickNew() {

        NewTrainingDialog.showDialog(activity as AppCompatActivity, object : NewTrainingDialog.Listener{
            override fun onClick(name: String) {
                val item = TrainingItem(
                    null,
                    name,
                    TimeManager.getCurrentTime()
                )
                mainViewModel.insertTraining(item)
            }
        },"")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRc()
        observer()
    }


    private fun initRc() = with(binding){
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterTraining(this@HomeFragment)
        rcView.adapter = adapter
    }

    private fun observer(){
        mainViewModel.allTraining.observe(viewLifecycleOwner){
            adapter.updateAdapter(it)
            binding.tvEmpty.visibility =if (it.isEmpty()){
                View.VISIBLE
            } else {
                View.GONE
            }

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    override fun deleteItem(id: Int) {
        DeleteDialog.showDialog(context as AppCompatActivity,object : DeleteDialog.Listener{
            override fun onClick() {
                mainViewModel.deleteTraining(id, true)
            }
        })
    }

    override fun onClickItem(trainingItem: TrainingItem) {
        val i = Intent(activity, TrainingActivity::class.java).apply {
            putExtra(TrainingActivity.TRAINING_ITEM_NAME, trainingItem)

        }
        startActivity(i)
    }

    override fun updateItem(item: TrainingItem) {
        NewTrainingDialog.showDialog(activity as AppCompatActivity, object : NewTrainingDialog.Listener{
            override fun onClick(name: String) {
                mainViewModel.updateTraining(item.copy(name = name))
            }
        },item.name)
    }
}