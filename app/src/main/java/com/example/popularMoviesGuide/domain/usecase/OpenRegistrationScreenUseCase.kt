package com.example.popularMoviesGuide.domain.usecase

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.firebase.ui.auth.AuthUI

class OpenRegistrationScreenUseCase {

    fun startRegistrationScreen(signInLauncher: ActivityResultLauncher<Intent>) {
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )

        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
        signInLauncher.launch(signInIntent)
    }

}