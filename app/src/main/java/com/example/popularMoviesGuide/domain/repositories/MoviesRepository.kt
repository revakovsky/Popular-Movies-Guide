package com.example.popularMoviesGuide.domain.repositories

import com.example.popularMoviesGuide.domain.models.moviesList.Movie

interface MoviesRepository {

    fun getMoviesList(): Result<List<Movie>>

}