package com.example.popularMoviesGuide.data.storage.firebaseStorage

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.example.popularMoviesGuide.R
import com.example.popularMoviesGuide.data.storage.AuthStorage
import com.firebase.ui.auth.AuthUI

class FirebaseAuthStorage : AuthStorage {

    override fun launchRegistrationScreen(launcher: ActivityResultLauncher<Intent>) {
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build(),
            AuthUI.IdpConfig.AnonymousBuilder().build()
        )

        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .setTheme(R.style.AuthScreenTheme)
            .build()

        launcher.launch(signInIntent)
    }

}