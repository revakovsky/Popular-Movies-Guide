package com.example.popularMoviesGuide.data.repository

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.example.popularMoviesGuide.data.storage.AuthStorage
import com.example.popularMoviesGuide.data.storage.firebasestorage.FirebaseAuthStorage
import com.example.popularMoviesGuide.domain.repositories.RegisterScreenRepository


class RegisterScreenRepositoryImpl(
    private val authStorage: AuthStorage = FirebaseAuthStorage()
) : RegisterScreenRepository {

    override fun launchRegistrationScreen(launcher: ActivityResultLauncher<Intent>) {
        authStorage.launchRegistrationScreen(launcher)
    }

}