package com.example.popularMoviesGuide.domain.usecase

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.example.popularMoviesGuide.domain.repositories.RegisterScreenRepository

class OpenRegistrationScreenUseCase(private val registerScreenRepository: RegisterScreenRepository) {

    fun launchRegistrationScreen(signInLauncher: ActivityResultLauncher<Intent>) {
        registerScreenRepository.launchRegistering(signInLauncher)
    }

}