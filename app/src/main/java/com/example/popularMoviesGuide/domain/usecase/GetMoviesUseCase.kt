package com.example.popularMoviesGuide.domain.usecase

import com.example.popularMoviesGuide.domain.models.moviesList.Movie
import com.example.popularMoviesGuide.domain.repositories.MoviesRepository

class GetMoviesUseCase(
    private val moviesRepository: MoviesRepository
) {

    fun invoke(): Result<List<Movie>> {
        return moviesRepository.getMoviesList()
    }

}