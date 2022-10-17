package com.example.popularMoviesGuide.domain.usecase

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.example.popularMoviesGuide.domain.repositories.RegisterScreenRepository

class OpenRegistrationScreenUseCase(
    private val registerScreenRepository: RegisterScreenRepository,
) {

    fun invoke(signInLauncher: ActivityResultLauncher<Intent>) {
        registerScreenRepository.launchRegistrationScreen(signInLauncher)
    }

}