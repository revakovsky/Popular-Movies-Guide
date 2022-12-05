package com.example.popularMoviesGuide.data.models.moviesList

data class DbResponseDto(
    val page: Int,
    val results: List<MovieDto>,
    val total_pages: Int,
    val total_results: Int
)
