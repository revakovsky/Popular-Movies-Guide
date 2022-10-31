package com.example.popularMoviesGuide.data.mappers

import com.example.popularMoviesGuide.data.models.DataUser
import com.example.popularMoviesGuide.domain.models.User

class DataUserMapperImpl : DataUserMapper {

    override fun mapToFirebaseUser(user: User): DataUser {
        return DataUser(user.email, user.uid, user.name, user.isAnonymous)
    }

}