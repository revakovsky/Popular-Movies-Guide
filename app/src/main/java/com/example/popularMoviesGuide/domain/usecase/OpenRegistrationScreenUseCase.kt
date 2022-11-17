package com.example.popularMoviesGuide.domain.usecase

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.example.popularMoviesGuide.domain.repositories.RegisteringRepository

class OpenRegistrationScreenUseCase(
    private val registeringRepository: RegisteringRepository
) {

    fun invoke(signInLauncher: ActivityResultLauncher<Intent>) {
        registeringRepository.launchRegistrationScreen(signInLauncher)
    }

}