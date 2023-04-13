package com.github.mishkaff89.fitnessnote.activities

import android.app.Application
import com.github.mishkaff89.fitnessnote.database.MainDB

class MainApp: Application() {
    val database by lazy { MainDB.getDataBase(this) }
}