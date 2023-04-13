package com.github.mishkaff89.fitnessnote.activities


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import com.github.mishkaff89.fitnessnote.R
import com.github.mishkaff89.fitnessnote.database.MainDB
import com.github.mishkaff89.fitnessnote.database.MainViewModel
import com.github.mishkaff89.fitnessnote.databinding.ActivityMainBinding
import com.github.mishkaff89.fitnessnote.fragments.FragmentManager
import com.github.mishkaff89.fitnessnote.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FragmentManager.setFragment(HomeFragment.newInstance(), this)
        mainViewModel = MainViewModel(MainDB.getDataBase(this))

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.logo_action_bar)
        supportActionBar?.setTitle(R.string.app_main)

        //Below API 29 (While Pasting the code delete this comment)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding.flAddButton.setOnClickListener {
            FragmentManager.currentFrag?.onClickNew()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.compare -> {
                startActivity(Intent(this, CompareActivity::class.java))
            }
            R.id.library -> {
                startActivity(Intent(this, LibraryActivity::class.java))
            }

        }
        return super.onOptionsItemSelected(item)
    }
    
}