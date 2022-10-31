package com.example.popularMoviesGuide.domain.mappers

import com.example.popularMoviesGuide.data.models.DataUser
import com.example.popularMoviesGuide.domain.models.User

class UserMapper {

    fun mapToDataUser(user: User): DataUser {
        return DataUser(user.email, user.uid, user.name, user.isAnonymous)
    }

}