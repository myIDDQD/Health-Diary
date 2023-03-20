package com.example.healthdiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import com.example.healthdiary.databinding.ActivityDiseasesBinding

class DiseasesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiseasesBinding
    private lateinit var selectedBodyParts: MutableSet<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDiseasesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        selectedBodyParts = mutableSetOf()

        binding.checkBoxHead.setOnClickListener {
            bindCheckBox(binding.checkBoxHead)
        }

        binding.checkBoxBody.setOnClickListener {
            bindCheckBox(binding.checkBoxBody)
        }

        binding.checkBoxHands.setOnClickListener {
            bindCheckBox(binding.checkBoxHands)
        }

        binding.checkBoxLegs.setOnClickListener {
            bindCheckBox(binding.checkBoxLegs)
        }


        binding.addNote.setOnClickListener {
            val intent = Intent(this, PainActivity::class.java)

            if (selectedBodyParts.isEmpty()) {
                Toast.makeText(this, "Select parts of body", Toast.LENGTH_SHORT).show()
            } else {
                intent.putExtra("selected_body_parts", selectedBodyParts.toTypedArray())
                startActivity(intent)
            }
        }
    }

    private fun bindCheckBox(checkBox: CheckBox) {
        val checkBoxText = checkBox.text.toString()

        fun showToast(selected: Boolean) {
            if (selected) {
                Toast.makeText(
                    this,
                    "Body part ${checkBox.text.toString().toLowerCase()} selected!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Body part ${checkBox.text.toString().toLowerCase()} unselected!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        if (selectedBodyParts.contains(checkBoxText)) {
            selectedBodyParts.remove(checkBoxText)
            showToast(false)
        } else {
            selectedBodyParts.add(checkBoxText)
            showToast(true)
        }
    }
}