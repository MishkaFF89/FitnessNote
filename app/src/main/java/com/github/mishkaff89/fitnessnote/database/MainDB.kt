package com.github.mishkaff89.fitnessnote.database

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.github.mishkaff89.fitnessnote.entity.ExerciseItem
import com.github.mishkaff89.fitnessnote.entity.LibraryItem
import com.github.mishkaff89.fitnessnote.entity.TrainingItem


@Database (entities = [TrainingItem::class, ExerciseItem::class, LibraryItem::class], version = 2,
exportSchema = true)
abstract class MainDB:RoomDatabase() {

    abstract fun getDao():Dao

    companion object{
        @Volatile
        private var INSTANCE: MainDB? = null
        fun getDataBase(context: Context):MainDB{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDB::class.java,
                    "mainDb"
                ).fallbackToDestructiveMigration()
                    .build()
                instance
            }
        }
    }

}