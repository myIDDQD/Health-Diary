package com.example.healthdiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.healthdiary.databinding.ActivityNoteBinding
import java.time.LocalDateTime

class NoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        val intentExtraArray = intent.getStringArrayExtra("selected_body_parts")

        // TODO filling fields when start this Activity
    }
}