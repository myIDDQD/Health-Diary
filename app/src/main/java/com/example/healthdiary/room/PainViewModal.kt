package com.example.healthdiary.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PainViewModal (application: Application) :AndroidViewModel(application) {

    // on below line we are creating a variable
    // for our all Pains list and repository
    val allPains : LiveData<List<Pain>>
    val repository : PainRepository

    // on below line we are initializing
    // our dao, repository and all Pains
    init {
        val dao = PainDatabase.getDatabase(application).getPainsDao()
        repository = PainRepository(dao)
        allPains = repository.allPains
    }

    // on below line we are creating a new method for deleting a Pain. In this we are
    // calling a delete method from our repository to delete our Pain.
    fun deletePain (Pain: Pain) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(Pain)
    }

    // on below line we are creating a new method for updating a Pain. In this we are
    // calling a update method from our repository to update our Pain.
    fun updatePain(Pain: Pain) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(Pain)
    }


    // on below line we are creating a new method for adding a new Pain to our database
    // we are calling a method from our repository to add a new Pain.
    fun addPain(Pain: Pain) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(Pain)
    }
}
