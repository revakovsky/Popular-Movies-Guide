package com.example.popularMoviesGuide.data.repository

import com.example.popularMoviesGuide.data.mappers.DataUserMapper
import com.example.popularMoviesGuide.data.storage.LocalStorage
import com.example.popularMoviesGuide.domain.models.User
import com.example.popularMoviesGuide.domain.repositories.LocalRepository

class LocalRepositoryImpl(
    private val mapper: DataUserMapper,
    private val localStorage: LocalStorage
) : LocalRepository {

    override fun saveUserUid(user: User) {
        localStorage.saveUid(mapper.mapToFirebaseUser(user))
    }

    override fun getUserUid(): String {
        return localStorage.getUid()
    }

    override fun saveUserEnteringCounter(counter: Int) {
        localStorage.saveEnteringCounter(counter)
    }

    override fun getUserEnteringCounter(): Int {
        return localStorage.getEnteringCounter()
    }

}