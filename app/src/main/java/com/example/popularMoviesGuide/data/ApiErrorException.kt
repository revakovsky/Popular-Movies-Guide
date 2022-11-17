package com.example.popularMoviesGuide.data

data class ApiErrorException(
    override val message: String
) : Exception(message)
