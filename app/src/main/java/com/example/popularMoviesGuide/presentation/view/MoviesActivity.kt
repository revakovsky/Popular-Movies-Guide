package com.example.popularMoviesGuide.presentation.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.popularMoviesGuide.R
import com.example.popularMoviesGuide.presentation.adapters.CustomAdapter
import com.example.popularMoviesGuide.presentation.viewmodel.MoviesViewModel

class MoviesActivity : AppCompatActivity(), CustomAdapter.ItemClickListener {

    private val moviesViewModel: MoviesViewModel = MoviesViewModel()
    private val errorViewModel: MoviesViewModel = MoviesViewModel()

    private lateinit var moviesRecycler: RecyclerView
    private lateinit var moviesAdapter: CustomAdapter

    lateinit var customToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        customToolbar = findViewById(R.id.custom_toolbar)
        setSupportActionBar(customToolbar)

        initViews()
        initObservers()
        moviesViewModel.getMovies()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tool_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.toolbar_search -> Toast.makeText(this, "searching", Toast.LENGTH_SHORT).show()
            R.id.toolbar_favorite -> Toast.makeText(this, "show the favorite", Toast.LENGTH_SHORT)
                .show()
        }
        return true
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