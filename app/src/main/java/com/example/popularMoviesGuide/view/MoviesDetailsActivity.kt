package com.example.popularMoviesGuide.view

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.popularMoviesGuide.R
import com.example.popularMoviesGuide.data.MovieDetails
import com.example.popularMoviesGuide.viewmodel.MoviesViewModel
import com.squareup.picasso.Picasso

class MoviesDetailsActivity : AppCompatActivity() {
    private val mViewModel : MoviesViewModel = MoviesViewModel()

    private lateinit var mTitle: TextView
    private lateinit var mReleaseDate: TextView
    private lateinit var mScore: TextView
    private lateinit var mOverview: TextView
    private lateinit var mBanner: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_details)

        val id = intent.getIntExtra("id", 0)
        Log.d("TAG", "id: $id")

        initViews()
        initObservers()
        mViewModel.getMovieDetails(id)

    }

    private fun initObservers() {
        mViewModel.apply {
            movieDetails.observe(this@MoviesDetailsActivity) {
                setMovieInformation(it)
            }
        }
    }

    private fun setMovieInformation(movieDetails: MovieDetails?) {
        mTitle.text = movieDetails?.original_title
        mReleaseDate.text = movieDetails?.release_date
        mScore.text = movieDetails?.vote_average.toString()
        mOverview.text = movieDetails?.overview

        Picasso.get().load("https://image.tmdb.org/t/p/w500/" + movieDetails?.backdrop_path).into(mBanner);
    }

    private fun initViews() {
        mTitle = findViewById(R.id.movies_details_title)
        mReleaseDate = findViewById(R.id.movies_details_body_container_data)
        mScore = findViewById(R.id.movies_details_body_container_score)
        mOverview = findViewById(R.id.movies_details_body_container_overview)
        mBanner = findViewById(R.id.movies_details_image_banner)
    }
}