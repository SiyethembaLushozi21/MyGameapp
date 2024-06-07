package com.example.mygameapp


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailedViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        val textViewAverage: TextView = findViewById(R.id.textViewAverage)
        val btnBack: Button = findViewById(R.id.btnBack)

        val screenTimeData = intent.getSerializableExtra("screenTimeData") as ArrayList<Pair<Int, Int>>
        val details = StringBuilder()
        var totalScreenTime = 0

        for ((index, data) in screenTimeData.withIndex()) {
            details.append("Day ${index + 1}: Morning - ${data.first} mins, Afternoon - ${data.second} mins\n")
            totalScreenTime += data.first + data.second
        }

        val averageScreenTime = if (screenTimeData.isNotEmpty()) totalScreenTime / screenTimeData.size else 0

        textViewDetails.text = details.toString()
        textViewAverage.text = "Average Screen Time: $averageScreenTime mins"

        btnBack.setOnClickListener {
            finish()
        }
    }
}
