package com.example.recycleme.ui.result

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.recycleme.R
import com.example.recycleme.ui.maps.MapsActivity

class ResultActivity : AppCompatActivity() {
    private lateinit var resultImage: ImageView
    private lateinit var resultText: TextView
    private lateinit var adviseText: TextView
    private lateinit var actionButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result1)

        // Initialize views
        resultImage = findViewById(R.id.result_image)
        resultText = findViewById(R.id.result_text1)
        adviseText = findViewById(R.id.advise_text1)
        actionButton = findViewById(R.id.located_button)

        // Set the result text and advice text
        resultText.text = getString(R.string.result1) // Replace with dynamic text if needed
        adviseText.text = getString(R.string.advise1) // Replace with dynamic text if needed

        actionButton.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        // Optionally, set an image for the ImageView
        resultImage.setImageResource(R.drawable.ic_place_holder) // Replace with dynamic image if needed
    }
}