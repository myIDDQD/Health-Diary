package com.gtappdevelopers.noteapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.healthdiary.PainActivity
import com.example.healthdiary.R
import com.example.healthdiary.room.Pain
import com.example.healthdiary.room.PainViewModal
import java.text.SimpleDateFormat
import java.util.*

class AddEditPainActivity : AppCompatActivity() {
    // on below line we are creating
    // variables for our UI components.
    lateinit var noteTitleEdt: EditText
    lateinit var noteEdt: EditText
    lateinit var saveBtn: Button

    // on below line we are creating variable for
    // viewmodal and integer for our note id.
    lateinit var viewModal: PainViewModal
    var noteID = -1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_pain)

        // on below line we are initializing our view modal.
        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(PainViewModal::class.java)

        // on below line we are initializing all our variables.
        noteTitleEdt = findViewById(R.id.idEdtPainName)
        noteEdt = findViewById(R.id.idEdtPainDesc)
        saveBtn = findViewById(R.id.idBtn)

        // on below line we are getting data passed via an intent.
        val noteType = intent.getStringExtra("noteType")
        if (noteType.equals("Edit")) {
            // on below line we are setting data to edit text.
            val noteTitle = intent.getStringExtra("noteTitle")
            val noteDescription = intent.getStringExtra("noteDescription")
            noteID = intent.getIntExtra("noteId", -1)
            saveBtn.setText("Update Note")
            noteTitleEdt.setText(noteTitle)
            noteEdt.setText(noteDescription)
        } else {
            saveBtn.setText("Save Note")
        }

        // on below line we are adding
        // click listener to our save button.
        saveBtn.setOnClickListener {
            // on below line we are getting
            // title and desc from edit text.
            val noteTitle = noteTitleEdt.text.toString()
            val painDescription = noteEdt.text.toString()
            // on below line we are checking the type
            // and then saving or updating the data.
            if (noteType.equals("Edit")) {
                if (noteTitle.isNotEmpty() && painDescription.isNotEmpty()) {
                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val currentDateAndTime: String = sdf.format(Date())
                    val updatedNote = Pain(0, currentDateAndTime, painDescription)
//                    updatedNote.id = noteID
                    viewModal.updatePain(updatedNote)
                    Toast.makeText(this, "Note Updated..", Toast.LENGTH_LONG).show()
                }
            } else {
                if (noteTitle.isNotEmpty() && painDescription.isNotEmpty()) {
                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val currentDateAndTime: String = sdf.format(Date())
                    // if the string is not empty we are calling a
                    // add note method to add data to our room database.
                    viewModal.addPain(Pain(0, currentDateAndTime, painDescription))
                    Toast.makeText(this, "$noteTitle Added", Toast.LENGTH_LONG).show()
                }
            }
            // opening the new activity on below line
            startActivity(Intent(applicationContext, PainActivity::class.java))
            this.finish()
        }
    }

}
