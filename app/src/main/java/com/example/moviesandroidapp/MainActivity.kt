package com.example.moviesandroidapp

import android.os.Bundle
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesandroidapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener{
            val intent = Intent(this, CinemasActivity::class.java)
            startActivity(intent)
        }

        initializeMoviesView()
    }

    private fun initializeMoviesView() {
        val moviesView = binding.moviesView
        moviesView.layoutManager = LinearLayoutManager(this)

        val moviesData = ArrayList<MoviesViewModel>()
        fillMoviesWithSampleData(moviesData)

        val adapter = MoviesAdapter(moviesData)
        adapter.onItemClick = {
            val intent = Intent(this, MovieDetailsActivity::class.java)

            intent.putExtra("movieName", it.name)
            intent.putExtra("movieDescription", it.description)
            intent.putExtra("movieImage", it.image)

            startActivity(intent)
        }

        moviesView.adapter = adapter
    }

    private fun fillMoviesWithSampleData(moviesData: ArrayList<MoviesViewModel>) {
        for (i in 1..10) {
            val img = resources.getIdentifier("movie_sample_$i", "drawable", packageName)
            val description = "Movie $i description. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

            val movie = MoviesViewModel(img, "Movie $i", description)

            moviesData.add(movie)
        }
    }
}