package com.example.healthdiary

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healthdiary.room.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

import java.util.*

class PainActivity : AppCompatActivity(), PainClickInterface, PainClickDeleteInterface {

    // on below line we are creating a variable
    // for our recycler view, exit text, button and viewmodel.
    lateinit var viewModal: PainViewModal
    lateinit var painsRV: RecyclerView
    lateinit var addFAB: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pain)

        // on below line we are initializing
        // all our variables.
        painsRV = findViewById(R.id.painsRV)
        addFAB = findViewById(R.id.idFAB)

        // on below line we are setting layout
        // manager to our recycler view.
        painsRV.layoutManager = LinearLayoutManager(this)

        // on below line we are initializing our adapter class.
        val noteRVAdapter = PainRVAdapter(this, this, this)

        // on below line we are setting
        // adapter to our recycler view.
        painsRV.adapter = noteRVAdapter

        // on below line we are
        // initializing our view modal.
        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(PainViewModal::class.java)

        // on below line we are calling all notes method
        // from our view modal class to observer the changes on list.
        viewModal.allPains.observe(this, Observer { list ->
            list?.let {
                // on below line we are updating our list.
                noteRVAdapter.updateList(it)
            }
        })
        addFAB.setOnClickListener {
            // adding a click listener for fab button
            // and opening a new intent to add a new note.
            val intent = Intent(this@PainActivity, AddEditPainActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }

    override fun onPainClick(note: Pain) {
        // opening a new intent and passing a data to it.
        val intent = Intent(this@PainActivity, AddEditPainActivity::class.java)
        intent.putExtra("noteType", "Edit")
//        intent.putExtra("noteTitle", note.noteTitle)
        intent.putExtra("painDescription", note.painDescription)
//        intent.putExtra("noteId", note.id)
        startActivity(intent)
        this.finish()
    }

    override fun onDeleteIconClick(note: Pain) {
        // in on note click method we are calling delete
        // method from our view modal to delete our not.
        viewModal.deletePain(note)
        // displaying a toast message
        Toast.makeText(this, "${note.painDescription} Deleted", Toast.LENGTH_LONG).show()
    }
}
