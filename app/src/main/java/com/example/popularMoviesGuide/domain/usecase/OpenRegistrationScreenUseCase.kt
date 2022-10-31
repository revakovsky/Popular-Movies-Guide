package com.example.popularMoviesGuide.domain.usecase

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.example.popularMoviesGuide.domain.repositories.RemoteRepository

class OpenRegistrationScreenUseCase(
    private val remoteRepository: RemoteRepository,
) {

    fun invoke(signInLauncher: ActivityResultLauncher<Intent>) {
        remoteRepository.launchRegistrationScreen(signInLauncher)
    }

}