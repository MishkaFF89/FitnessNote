package com.github.mishkaff89.fitnessnote.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mishkaff89.fitnessnote.R
import com.github.mishkaff89.fitnessnote.adapters.CompareAdapter
import com.github.mishkaff89.fitnessnote.database.MainViewModel
import com.github.mishkaff89.fitnessnote.databinding.ActivityCompareBinding
import com.github.mishkaff89.fitnessnote.entity.ExerciseItem
import kotlin.collections.ArrayList

class CompareActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    lateinit var binding: ActivityCompareBinding
    lateinit var adapter: CompareAdapter


    private val mainViewModel: MainViewModel by viewModels{
        MainViewModel.MainViewModelFactory((applicationContext as MainApp).database)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompareBinding.inflate(layoutInflater)
        setContentView(binding.root)
        rcView()
        itemObserver()
        supportActionBar?.setTitle(R.string.compare)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.find_menu, menu)
        val item =menu?.findItem(R.id.search_action)
        val searchView = item?.actionView as SearchView
        searchView.isSubmitButtonEnabled = true
        searchView.setOnQueryTextListener(this)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun rcView() = with(binding){
        adapter = CompareAdapter()
        rcLibrary.layoutManager = LinearLayoutManager(this@CompareActivity)
        rcLibrary.adapter = adapter
    }

    private fun itemObserver(){
        mainViewModel.exerciseItems.observe(this){
            val tempList = ArrayList<ExerciseItem>()
            it.forEach{
                item ->
                val exerciseItem = ExerciseItem(
                    item.id,
                    item.name,
                    item.type,
                    item.listId,
                    item.time,
                    item.value1_1,
                    item.value1_2,
                    item.value1_3,
                    item.value1_4,
                    item.value1_5,
                    item.value1_6,
                    item.value1_7,
                    item.value1_8,
                    item.value1_9,
                    item.value1_10,
                    item.value2_1,
                    item.value2_2,
                    item.value2_3,
                    item.value2_4,
                    item.value2_5,
                    item.value2_6,
                    item.value2_7,
                    item.value2_8,
                    item.value2_9,
                    item.value2_10
                )
                tempList.add(exerciseItem)
            }
            adapter.submitList(tempList.asReversed())

            if (it.isEmpty()){
                binding.tvLibraryEmpty.visibility = View.VISIBLE
                binding.imEmpty.visibility = View.VISIBLE
            } else{
                binding.tvLibraryEmpty.visibility = View.GONE
                binding.imEmpty.visibility = View.GONE
            }

        }
    }
    private fun searchItems(name: String){
        val searchItem = "%$name%"

        mainViewModel.searchItem(searchItem).observe(this){list ->
            list.let {
                adapter.submitList(it.asReversed())
            }

        }
    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null){
            searchItems(query)
        }
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if (query != null){
            searchItems(query)
        }
        return true
    }
}