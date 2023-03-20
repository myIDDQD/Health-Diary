package com.example.healthdiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

//        val intentExtraArray = intent.getStringArrayExtra("selected_body_parts")
//        binding.spinnerBodyParts.text = intentExtraArray?.joinToString(", ") ?: "Error"

        // access the items of the list
        val languages = resources.getStringArray(R.array.Languages)

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, languages)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(this@MainActivity,
                        getString(R.string.selected_item) + " " +
                                "" + languages[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        binding.noteDateTextView.text = LocalDateTime.now().format(formatter).toString()

        // TODO filling fields when start this Activity
    }
}