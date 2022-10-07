package com.example.popularMoviesGuide.data.repository

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.example.popularMoviesGuide.domain.repositories.RegisterScreenRepository
import com.firebase.ui.auth.AuthUI

class RegisterScreenRepositoryImpl : RegisterScreenRepository {

    override fun launchRegisterScreen(launcher: ActivityResultLauncher<Intent>) {
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )

        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
        launcher.launch(signInIntent)
    }

}