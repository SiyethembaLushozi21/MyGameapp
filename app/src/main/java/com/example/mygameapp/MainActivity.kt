package com.example.mygameapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextMorning: EditText
    private lateinit var editTextAfternoon: EditText
    private val screenTimeData = mutableListOf<Pair<Int, Int>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextMorning = findViewById(R.id.editTextMorning)
        editTextAfternoon = findViewById(R.id.editTextAfternoon)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)
        val btnViewDetails: Button = findViewById(R.id.btnViewDetails)

        btnSubmit.setOnClickListener {
            val morningTime = editTextMorning.text.toString().toIntOrNull() ?: 0
            val afternoonTime = editTextAfternoon.text.toString().toIntOrNull() ?: 0
            screenTimeData.add(Pair(morningTime, afternoonTime))
            editTextMorning.text.clear()
            editTextAfternoon.text.clear()
        }

        btnViewDetails.setOnClickListener {
            val intent = Intent(this, DetailedViewActivity::class.java)
            intent.putExtra("screenTimeData", ArrayList(screenTimeData))
            startActivity(intent)
        }
    }
}
