package com.example.popularMoviesGuide.domain.repositories

import com.example.popularMoviesGuide.domain.models.User

interface LocalRepository {

    fun saveUserUid(user: User)

    fun getUserUid(): String

}