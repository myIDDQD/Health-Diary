package com.example.healthdiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.healthdiary.databinding.ActivityNoteBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class NoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteBinding

    private val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm") // ("yyyy-MM-dd HH:mm")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intentExtraArray = intent.getStringArrayExtra("selected_body_parts")

        binding.bodyParts.text = intentExtraArray?.joinToString(", ") ?: "Error"

        binding.noteDateTextView.text = LocalDateTime.now().format(formatter).toString()

        // TODO filling fields when start this Activity
    }
}