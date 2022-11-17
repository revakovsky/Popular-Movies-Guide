package com.example.popularMoviesGuide.model.repository

import com.example.popularMoviesGuide.data.models.moviesDetails.MovieDetails
import com.example.popularMoviesGuide.data.models.moviesList.DbResponseDto
import retrofit2.Call

/**
 * Repository provides info taken from MovieDB API
 */

interface MoviesDBRepository {

    /**
     * Return the list of popular movies [DbResponseDto]
     */

    fun getMovies() : Call<DbResponseDto>

    /** return the info for a single movie by returning [MovieDetails]
     * @param id - identification number of needed movie
     **/

    fun getMovieDetails(id : Int) : Call<MovieDetails>
}
