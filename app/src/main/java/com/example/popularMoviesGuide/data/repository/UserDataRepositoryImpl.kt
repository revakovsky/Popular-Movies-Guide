package com.example.popularMoviesGuide.data.repository

import com.example.popularMoviesGuide.data.mappers.UserMapper
import com.example.popularMoviesGuide.data.storage.UserStorage
import com.example.popularMoviesGuide.data.storage.firebasestorage.FirebaseUserStorage
import com.example.popularMoviesGuide.domain.models.User
import com.example.popularMoviesGuide.domain.repositories.UserDataRepository

class UserDataRepositoryImpl(
    private val mapper: UserMapper = UserMapper(),
    private val userStorage: UserStorage = FirebaseUserStorage(),
) : UserDataRepository {

    override fun updateUserData(user: User) {
        userStorage.updateData(mapper.mapToFirebaseUser(user))
    }

}