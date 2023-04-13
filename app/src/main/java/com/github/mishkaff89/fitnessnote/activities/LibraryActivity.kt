package com.github.mishkaff89.fitnessnote.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mishkaff89.fitnessnote.R
import com.github.mishkaff89.fitnessnote.adapters.ExerciseAdapter
import com.github.mishkaff89.fitnessnote.adapters.LibraryAdapter
import com.github.mishkaff89.fitnessnote.database.MainViewModel
import com.github.mishkaff89.fitnessnote.databinding.ActivityLibraryMainBinding
import com.github.mishkaff89.fitnessnote.dialogs.DeleteDialog
import com.github.mishkaff89.fitnessnote.dialogs.UpdateLibraryDialog
import com.github.mishkaff89.fitnessnote.entity.LibraryItem

class LibraryActivity : AppCompatActivity(), LibraryAdapter.Listener {
    lateinit var binding: ActivityLibraryMainBinding
    lateinit var adapter: LibraryAdapter

    private val mainViewModel: MainViewModel by viewModels{
        MainViewModel.MainViewModelFactory((applicationContext as MainApp).database)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLibraryMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle(R.string.library)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        rcView()
        itemObserver()
    }

    private fun rcView() = with(binding){
        rcLibrary.layoutManager = LinearLayoutManager(this@LibraryActivity)
        adapter = LibraryAdapter(this@LibraryActivity)
        rcLibrary.adapter = adapter
    }
    private fun itemObserver(){
        mainViewModel.allLibraryItems.observe(this){
            adapter.updateAdapter(it)
            if (it.isEmpty()){
                binding.emptyLibrary.visibility = View.VISIBLE
                binding.emptyTextLibrary.visibility = View.VISIBLE
            } else{
                binding.emptyLibrary.visibility = View.GONE
                binding.emptyTextLibrary.visibility = View.GONE
            }

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun deleteItem(id: Int) {
        DeleteDialog.showDialog(this ,object : DeleteDialog.Listener{
            override fun onClick() {
                mainViewModel.deleteLibraryItem(id)
            }
        })
    }

    override fun updateItem(item: LibraryItem) {
        UpdateLibraryDialog.showDialog(this, item, object : UpdateLibraryDialog.Listener{
            override fun onClick(libraryItem: LibraryItem) {
               mainViewModel.updateLibraryItem(libraryItem)
            }

        })
    }
}