package com.example.healthdiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.healthdiary.databinding.ActivityDiseasesBinding

class DiseasesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiseasesBinding

    private lateinit var intent: Intent

    private lateinit var partsBody : Array<String>
    private lateinit var spinner : Spinner
    private lateinit var arrayAdapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiseasesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupSpinner()

        binding.addNote.setOnClickListener {
            intent = Intent(this, NoteActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupSpinner() {
        partsBody = resources.getStringArray(R.array.Parts)
        spinner = binding.spinner
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, partsBody)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    this@DiseasesActivity,
                    getString(R.string.selected_item) + " " + partsBody[position],
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Code to perform some action when nothing is selected
            }
        }
    }
}