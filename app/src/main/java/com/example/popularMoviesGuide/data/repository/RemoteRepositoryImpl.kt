package com.example.popularMoviesGuide.data.repository

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.example.popularMoviesGuide.data.mappers.DataUserMapper
import com.example.popularMoviesGuide.data.storage.AuthStorage
import com.example.popularMoviesGuide.data.storage.UserStorage
import com.example.popularMoviesGuide.domain.models.User
import com.example.popularMoviesGuide.domain.repositories.RemoteRepository

class RemoteRepositoryImpl(
    private val mapper: DataUserMapper,
    private val userStorage: UserStorage,
    private val authStorage: AuthStorage
) : RemoteRepository {

    override fun launchRegistrationScreen(launcher: ActivityResultLauncher<Intent>) {
        authStorage.launchRegistrationScreen(launcher)
    }

    override fun updateUserData(user: User) {
        userStorage.updateData(mapper.mapToFirebaseUser(user))
    }

}