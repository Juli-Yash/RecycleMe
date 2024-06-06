package com.example.recycleme.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.recycleme.R
import com.example.recycleme.ui.home.HomeActivity

class OnBoardingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_page)

        val buttonWt1 = findViewById<Button>(R.id.ButtonOnBoarding)
        buttonWt1.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
    }
}
