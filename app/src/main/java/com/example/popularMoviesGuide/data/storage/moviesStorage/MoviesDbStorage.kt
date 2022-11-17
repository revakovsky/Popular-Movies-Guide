package com.example.popularMoviesGuide.data.storage.moviesStorage

import com.example.popularMoviesGuide.data.ApiErrorException
import com.example.popularMoviesGuide.data.apis.ApiInterface
import com.example.popularMoviesGuide.data.models.moviesList.DbResponseDto
import com.example.popularMoviesGuide.data.storage.MoviesStorage
import retrofit2.HttpException
import java.io.IOException

class MoviesDbStorage
//    : MoviesStorage
{

//    override fun getMovies(apiInterface: ApiInterface): Result<DbResponseDto> {
//        return handleCatching {
//            apiInterface.getMovies(API_KEY, "en-US", 1)
//        }
//    }

    companion object {
        private const val API_KEY: String = "248691836d283188a26679570aae0ef6"
    }

    private inline fun <R> handleCatching(block: () -> R): Result<R> {
        return try {
            Result.success(block())
        } catch (e: HttpException) {
            Result.failure(ApiErrorException("Error ${e.code()}"))
        } catch (e: IOException) {
            Result.failure(ApiErrorException("You don't have internet connection"))
        }
    }

}