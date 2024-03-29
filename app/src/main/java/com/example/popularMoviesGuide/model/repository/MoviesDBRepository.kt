package com.example.popularMoviesGuide.model.repository

import com.example.popularMoviesGuide.data.MovieDetails
import com.example.popularMoviesGuide.data.MoviesDataBase
import retrofit2.Call

/**
 * Repository provides info taken from MovieDB API
 */

interface MoviesDBRepository {

    /**
     * Return the list of popular movies [MoviesDataBase]
     */

    fun getMovies() : Call<MoviesDataBase>

    /** return the info for a single movie by returning [MovieDetails]
     * @param id - identification number of needed movie
     **/

    fun getMovieDetails(id : Int) : Call<MovieDetails>
}
