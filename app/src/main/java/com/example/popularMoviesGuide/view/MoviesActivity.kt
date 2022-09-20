package com.example.popularMoviesGuide.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.popularMoviesGuide.R
import com.example.popularMoviesGuide.view.adapters.CustomAdapter
import com.example.popularMoviesGuide.viewmodel.MoviesViewModel

class MoviesActivity : AppCompatActivity(), CustomAdapter.ItemClickListener {

    private val moviesViewModel: MoviesViewModel = MoviesViewModel()
    private val errorViewModel: MoviesViewModel = MoviesViewModel()

    private lateinit var moviesRecycler: RecyclerView
    private lateinit var moviesAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        initViews()
        initObservers()
        moviesViewModel.getMovies()
    }


    private fun initViews() {
        moviesRecycler = findViewById(R.id.recyclerview)
        moviesRecycler.layoutManager = GridLayoutManager(this, 2)

    }

    private fun initObservers() {
        moviesViewModel.apply {
            movies.observe(this@MoviesActivity) {
                moviesAdapter = CustomAdapter(it, this@MoviesActivity)
                moviesRecycler.adapter = moviesAdapter
            }
        }
        errorViewModel.apply {
            errorMessage.observe(this@MoviesActivity) {
                it.getContentIfNotHandled()?.let {
                    Toast.makeText(this@MoviesActivity, it, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finishAffinity()
    }

    override fun onItemClick(itemId: Int) {
        val intent = Intent(this@MoviesActivity, MoviesDetailsActivity::class.java)
        intent.putExtra("id", itemId)
        startActivity(intent)
    }
}