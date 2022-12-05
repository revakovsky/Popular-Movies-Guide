package com.example.popularMoviesGuide.domain.models.moviesList

data class DbResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)
