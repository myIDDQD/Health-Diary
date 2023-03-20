package com.example.healthdiary.room

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import java.util.concurrent.Flow

class PainRepository(private val PainsDao: PainsDao) {

    // on below line we are creating a variable for our list
    // and we are getting all the Pains from our DAO class.
    val allPains: LiveData<List<Pain>> = PainsDao.getAllPains()

    // on below line we are creating an insert method
    // for adding the Pain to our database.
    suspend fun insert(Pain: Pain) {
        PainsDao.insert(Pain)
    }

    // on below line we are creating a delete method
    // for deleting our Pain from database.
    suspend fun delete(Pain: Pain){
        PainsDao.delete(Pain)
    }

    // on below line we are creating a update method for
    // updating our Pain from database.
    suspend fun update(Pain: Pain){
        PainsDao.update(Pain)
    }
}
