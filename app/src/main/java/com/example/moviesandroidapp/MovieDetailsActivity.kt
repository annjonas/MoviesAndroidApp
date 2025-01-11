package com.example.moviesandroidapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_details)

        val movieName = intent.getStringExtra("movieName")
        val movieDescription = intent.getStringExtra("movieDescription")
        val movieImage = intent.getStringExtra("movieImage")

        val textView: TextView = findViewById(R.id.textView2)
        textView.text = movieDescription
    }
}