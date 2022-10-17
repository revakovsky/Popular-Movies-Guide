package com.example.popularMoviesGuide.domain.repositories

import com.example.popularMoviesGuide.domain.models.User

interface UserDataRepository {

    fun updateUserData(user: User)

}