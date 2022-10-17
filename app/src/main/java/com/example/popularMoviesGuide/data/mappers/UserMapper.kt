package com.example.popularMoviesGuide.data.mappers

import com.example.popularMoviesGuide.data.models.FirebaseUser
import com.example.popularMoviesGuide.domain.models.User

class UserMapper {

    fun mapToFirebaseUser(user: User): FirebaseUser {
        return FirebaseUser(user.email, user.uid)
    }

}