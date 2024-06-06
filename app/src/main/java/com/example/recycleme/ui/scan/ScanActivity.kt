package com.example.recycleme.ui.scan

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.recycleme.R
import com.example.recycleme.ui.result.ResultActivity


class ScanActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var progressBar: ProgressBar

    private val takePicture = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap)
        } else {
            Toast.makeText(this, "Failed to take picture", Toast.LENGTH_SHORT).show()
        }
    }

    private val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            imageView.setImageURI(uri)
        } else {
            Toast.makeText(this, "Failed to pick image", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        imageView = findViewById(R.id.add_fotostory)
        val cameraButton: Button = findViewById(R.id.add_buttonkamera)
        val galleryButton: Button = findViewById(R.id.add_buttongallery)
        val uploadButton: Button = findViewById(R.id.button_add)
        progressBar = findViewById(R.id.add_pb)

        cameraButton.setOnClickListener {
            takePicture.launch(null)
        }

        galleryButton.setOnClickListener {
            pickImage.launch("image/*")
        }

        uploadButton.setOnClickListener {
            uploadImage()
        }
    }

    private fun uploadImage() {
        progressBar.visibility = View.VISIBLE

        // Simulate image upload process
        // TODO: Implement actual upload logic
        Toast.makeText(this, "Uploading image...", Toast.LENGTH_SHORT).show()

        // Hide progress bar after upload process (simulation)
        progressBar.visibility = View.GONE

        // Navigate to ResultActivity after upload process
        val intent = Intent(this, ResultActivity::class.java)
        startActivity(intent)
    }
}