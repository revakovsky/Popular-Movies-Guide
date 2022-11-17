package com.example.popularMoviesGuide.data.storage

import com.example.popularMoviesGuide.data.apis.ApiInterface
import com.example.popularMoviesGuide.data.models.moviesList.DbResponseDto

interface MoviesStorage {

    fun getMovies(apiInterface: ApiInterface): Result<DbResponseDto>

}