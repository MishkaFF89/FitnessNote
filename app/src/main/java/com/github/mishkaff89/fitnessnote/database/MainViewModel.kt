package com.github.mishkaff89.fitnessnote.database

import androidx.lifecycle.*
import com.github.mishkaff89.fitnessnote.entity.ExerciseItem
import com.github.mishkaff89.fitnessnote.entity.LibraryItem
import com.github.mishkaff89.fitnessnote.entity.TrainingItem
import kotlinx.coroutines.launch
import java.util.concurrent.Flow


class MainViewModel(database: MainDB): ViewModel() {
    val dao = database.getDao()

    //New training
    fun insertTraining(item: TrainingItem) = viewModelScope.launch{
        dao.insertTraining(item)
    }

    val  allTraining: LiveData<List<TrainingItem>> = dao.getAllTraining().asLiveData()

    fun deleteTraining(id: Int, deleteItem: Boolean) = viewModelScope.launch {
        if (deleteItem) dao.deleteTraining(id)
        dao.deleteExerciseWithTraining(id)
    }
    fun updateTraining(item: TrainingItem) = viewModelScope.launch {
        dao.updateTraining(item)
    }

    //New exercise
    val exerciseItems: LiveData<List<ExerciseItem>> =  dao.getAllExercise().asLiveData()


    fun insertExercise(item: ExerciseItem) = viewModelScope.launch {
        dao.insertExercise(item)
        if (!isLibraryItemExists(item.name)) dao.insertLibrary(LibraryItem(null, item.name))
    }

    fun getAllExerciseWithTraining(listId: Int): LiveData<List<ExerciseItem>>{
        return dao.getAllExerciseWithTraining(listId).asLiveData()
    }

    fun searchItem(name: String): LiveData<List<ExerciseItem>>{
        return dao.searchExercise(name).asLiveData()
    }


    fun updateExercise(item: ExerciseItem) = viewModelScope.launch {
        dao.updateExercise(item)
        if (!isLibraryItemExists(item.name)) dao.insertLibrary(LibraryItem(null, item.name))

    }

    fun deleteExercise(id: Int) = viewModelScope.launch {
        dao.deleteExercise(id)
    }


    //Library item

    val libraryItems = MutableLiveData<List<LibraryItem>>()

    val allLibraryItems: LiveData<List<LibraryItem>> = dao.getAllLibrary().asLiveData()

    fun getAllLibraryItems(name: String) = viewModelScope.launch{
        libraryItems.postValue(dao.getAllLibraryItems(name))
    }
    fun updateLibraryItem(item: LibraryItem) = viewModelScope.launch {
        dao.updateLibraryItem(item)
    }

    fun deleteLibraryItem(id: Int) = viewModelScope.launch {
        dao.deleteLibraryItem(id)
    }

    private suspend fun isLibraryItemExists(name: String): Boolean{
        return dao.getAllLibraryItems(name).isNotEmpty()
    }






    class MainViewModelFactory(val database: MainDB) : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(database) as T
            }
            throw IllegalArgumentException("Unknown ViewModelClass")
        }
    }
}