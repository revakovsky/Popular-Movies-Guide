package com.example.popularMoviesGuide.data.storage.firebaseStorage

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.example.popularMoviesGuide.R
import com.example.popularMoviesGuide.data.models.registering.DataUser
import com.example.popularMoviesGuide.data.storage.AuthStorage
import com.firebase.ui.auth.AuthUI
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

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

    override fun updateData(user: DataUser) {
        val database: DatabaseReference = Firebase.database.reference
        val uId = user.uid
        database.child("users").child(uId).setValue(user)
    }

}