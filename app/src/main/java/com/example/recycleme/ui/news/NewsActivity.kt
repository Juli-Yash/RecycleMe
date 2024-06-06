package com.example.recycleme.ui.news

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleme.R
import com.example.recycleme.databinding.ActivityNewsBinding
import com.example.recycleme.ui.home.HomeFragment
import com.example.recycleme.ui.profile.ProfileActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        // Initialize RecyclerView
        binding.rvBook.layoutManager = LinearLayoutManager(this)
        // Set adapter here, e.g.:
        // binding.rvBook.adapter = NewsAdapter(getNewsData())

        // Initialize BottomNavigationView
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.news -> {
                    startActivity(Intent(this, NewsActivity::class.java))
                    true
                }
                R.id.profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                else ->false
            }
            true
        }
    }
    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}