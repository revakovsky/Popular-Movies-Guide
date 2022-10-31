package com.example.popularMoviesGuide.data.mappers

import com.example.popularMoviesGuide.data.models.DataUser
import com.example.popularMoviesGuide.domain.models.User

interface DataUserMapper {

    fun mapToFirebaseUser(user: User): DataUser

}