package com.example.healthdiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.healthdiary.databinding.ActivityPainBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPainBinding

    private val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm") // ("yyyy-MM-dd HH:mm")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // set current date and time on textview
        binding.noteDateTextView.text = setCurrentDate()

//        val intentExtraArray = intent.getStringArrayExtra("selected_body_parts")
//        binding.spinnerBodyParts.text = intentExtraArray?.joinToString(", ") ?: "Error"

        // access the items of the list
        val bodyParts = resources.getStringArray(R.array.parts)

        // access the spinner
        if (binding.spinnerBodyParts != null) {

            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, bodyParts)
            binding.spinnerBodyParts.adapter = adapter


            binding.spinnerBodyParts.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(this@PainActivity,
                        getString(R.string.body_parts) + " " +
                                "" + bodyParts[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }



        // TODO filling fields when start this Activity
    }

    private fun setCurrentDate(): String {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
        val currentTime = LocalDateTime.now().format(formatter)

        return currentTime.toString()
    }
}