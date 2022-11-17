package com.example.popularMoviesGuide.data.mappers

import com.example.popularMoviesGuide.data.models.registering.DataUser
import com.example.popularMoviesGuide.domain.models.registering.User

interface UserMapper {

    fun mapToFirebaseUser(user: User): DataUser

}