package com.example.popularMoviesGuide.domain.models

data class User(
    val email: String,
    val uid: String,
    val name: String,
    val isAnonymous: Boolean
)
