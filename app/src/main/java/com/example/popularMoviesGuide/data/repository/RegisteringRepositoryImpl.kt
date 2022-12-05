package com.example.popularMoviesGuide.data.repository

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.example.popularMoviesGuide.data.mappers.UserMapper
import com.example.popularMoviesGuide.data.storage.AuthStorage
import com.example.popularMoviesGuide.data.storage.LocalStorage
import com.example.popularMoviesGuide.domain.models.registering.User
import com.example.popularMoviesGuide.domain.repositories.RegisteringRepository

class RegisteringRepositoryImpl(
    private val mapper: UserMapper,
    private val authStorage: AuthStorage,
    private val localStorage: LocalStorage
) : RegisteringRepository {

    override fun launchRegistrationScreen(launcher: ActivityResultLauncher<Intent>) {
        authStorage.launchRegistrationScreen(launcher)
    }

    override fun updateUserData(user: User) {
        authStorage.updateData(mapper.mapToFirebaseUser(user))
    }

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