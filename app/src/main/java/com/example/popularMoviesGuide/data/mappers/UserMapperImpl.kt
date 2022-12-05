package com.example.popularMoviesGuide.data.mappers

import com.example.popularMoviesGuide.data.models.registering.DataUser
import com.example.popularMoviesGuide.domain.models.registering.User

class UserMapperImpl : UserMapper {

    override fun mapToFirebaseUser(user: User): DataUser =
        DataUser(
            user.email,
            user.uid,
            user.name,
            user.isAnonymous
        )

}