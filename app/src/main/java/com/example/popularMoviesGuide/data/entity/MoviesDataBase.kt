package com.example.popularMoviesGuide.data.entity

data class MoviesDataBase(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)