package com.example.popularMoviesGuide.presentation.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.popularMoviesGuide.R
import com.example.popularMoviesGuide.data.entity.MovieDetails
import com.example.popularMoviesGuide.presentation.viewmodel.MoviesViewModel
import com.squareup.picasso.Picasso

class MoviesDetailsActivity : AppCompatActivity() {

    private val moviesViewModel : MoviesViewModel = MoviesViewModel()

    private lateinit var movieTitle: TextView
    private lateinit var movieReleaseDate: TextView
    private lateinit var movieScore: TextView
    private lateinit var movieOverview: TextView
    private lateinit var movieBanner: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_details)

        val id = intent.getIntExtra("id", 0)

        initViews()
        initObservers()
        moviesViewModel.getMovieDetails(id)

    }

    private fun initObservers() {
        moviesViewModel.apply {
            movieDetails.observe(this@MoviesDetailsActivity) {
                setMovieInformation(it)
            }
        }
    }

    private fun setMovieInformation(movieDetails: MovieDetails?) {
        movieTitle.text = movieDetails?.original_title
        movieReleaseDate.text = movieDetails?.release_date
        movieScore.text = movieDetails?.vote_average.toString()
        movieOverview.text = movieDetails?.overview

        val path = "https://image.tmdb.org/t/p/w500/" + movieDetails?.backdrop_path
        Picasso.get().load(path).into(movieBanner);
    }

    private fun initViews() {
        movieTitle = findViewById(R.id.movies_details_title)
        movieReleaseDate = findViewById(R.id.movies_details_release_date)
        movieScore = findViewById(R.id.movies_details_score)
        movieOverview = findViewById(R.id.movies_details_overview)
        movieBanner = findViewById(R.id.movies_details_banner)
    }
}