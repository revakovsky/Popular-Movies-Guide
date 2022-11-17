package com.example.popularMoviesGuide.data.repository

import com.example.popularMoviesGuide.data.apis.ApiInterface
import com.example.popularMoviesGuide.data.storage.MoviesStorage
import com.example.popularMoviesGuide.domain.models.moviesList.Movie
import com.example.popularMoviesGuide.domain.repositories.MoviesRepository

class MoviesRepositoryImpl(
    private val apiInterface: ApiInterface,
    private val moviesStorage: MoviesStorage
) : MoviesRepository {

    override fun getMoviesList(): Result<List<Movie>> {
        return moviesStorage.getMovies(apiInterface)
            .map { response -> response.results.map { it.toMovie() } }
    }

}
