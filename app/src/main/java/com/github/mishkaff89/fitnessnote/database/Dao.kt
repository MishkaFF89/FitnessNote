package com.github.mishkaff89.fitnessnote.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

import com.github.mishkaff89.fitnessnote.entity.ExerciseItem
import com.github.mishkaff89.fitnessnote.entity.LibraryItem
import com.github.mishkaff89.fitnessnote.entity.TrainingItem
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    //Training item
    @Insert
    suspend fun insertTraining(item: TrainingItem)
    @Query("SELECT * FROM training_items")
    fun getAllTraining(): Flow<List<TrainingItem>>
    @Query("DELETE FROM training_items WHERE id IS :id")
    suspend fun deleteTraining(id: Int)
    @Update
    suspend fun updateTraining(item: TrainingItem)

    //Library item
    @Insert
    suspend fun insertLibrary(item: LibraryItem)

    @Query("SELECT * FROM library_item WHERE name LIKE :name")
    suspend fun getAllLibraryItems(name: String): List<LibraryItem>

    @Query("SELECT * FROM library_item")
    fun getAllLibrary(): Flow<List<LibraryItem>>

    @Update
    suspend fun updateLibraryItem(item: LibraryItem)

    @Query("DELETE FROM library_item WHERE id IS :id")
    suspend fun deleteLibraryItem(id: Int)




    //Exercise item
    @Insert
    suspend fun insertExercise(item: ExerciseItem)

    @Update
    suspend fun updateExercise(item: ExerciseItem)

    @Query("SELECT * FROM exercise_item WHERE listId LIKE :listId")
    fun getAllExerciseWithTraining(listId: Int): Flow<List<ExerciseItem>>

    @Query("SELECT * FROM exercise_item")
     fun getAllExercise(): Flow<List<ExerciseItem>>

    @Query("SELECT * FROM exercise_item WHERE name LIKE :name")
    fun searchExercise(name: String): Flow<List<ExerciseItem>>

    @Query("DELETE FROM exercise_item WHERE id IS :id")
    suspend fun deleteExercise(id: Int)

    @Query("DELETE FROM exercise_item WHERE listId LIKE :listId")
    suspend fun deleteExerciseWithTraining(listId: Int)


}