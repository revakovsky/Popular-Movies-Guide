package com.example.popularMoviesGuide.data.repository

import com.example.popularMoviesGuide.data.storage.UserStorage
import com.example.popularMoviesGuide.data.storage.firebasestorage.FirebaseUserStorage
import com.example.popularMoviesGuide.data.storage.mappers.FirebaseUserMapper
import com.example.popularMoviesGuide.domain.models.User
import com.example.popularMoviesGuide.domain.repositories.UserDataRepository

class UserDataRepositoryImpl : UserDataRepository {

    private val mapper = FirebaseUserMapper()
    private val userStorage: UserStorage = FirebaseUserStorage()

    override fun updateData(user: User) {
        userStorage.updateData(mapper.mapToFirebaseUser(user))
    }

}