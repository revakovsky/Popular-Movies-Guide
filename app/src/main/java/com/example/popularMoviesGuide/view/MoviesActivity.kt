package com.example.popularMoviesGuide.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.popularMoviesGuide.R
import com.example.popularMoviesGuide.view.adapters.CustomAdapter
import com.example.popularMoviesGuide.viewmodel.MoviesViewModel

class MoviesActivity : AppCompatActivity(), CustomAdapter.ItemClickListener {

    private val mViewModel : MoviesViewModel = MoviesViewModel()

    private lateinit var mMoviesRecycler : RecyclerView
    private lateinit var mMoviesAdapter: CustomAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        initViews()
        initObservers()
        mViewModel.getMovies()
    }


    private fun initViews() {
        mMoviesRecycler = findViewById(R.id.recyclerview)

        // this creates a vertical layout Manager instead of list
        mMoviesRecycler.layoutManager = GridLayoutManager(this, 2)
    }

    private fun initObservers() {
        mViewModel.apply {
            movies.observe(this@MoviesActivity) {
                mMoviesAdapter = CustomAdapter(it, this@MoviesActivity)
                mMoviesRecycler.adapter = mMoviesAdapter
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finishAffinity()
        Log.d("testLogs", "application is closed")
    }

    override fun onItemClick(id: Int) {
        val intent = Intent(this@MoviesActivity, MoviesDetailsActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }
}