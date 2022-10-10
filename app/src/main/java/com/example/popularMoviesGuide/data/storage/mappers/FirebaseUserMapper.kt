package com.example.popularMoviesGuide.data.storage.mappers

import com.example.popularMoviesGuide.data.storage.models.FirebaseUser
import com.example.popularMoviesGuide.domain.models.User

class FirebaseUserMapper {

    private lateinit var firebaseUser: FirebaseUser

    fun mapToFirebaseUser(user: User) : FirebaseUser {
        firebaseUser.email = user.email
        firebaseUser.uid = user.uid
        return firebaseUser
    }

}