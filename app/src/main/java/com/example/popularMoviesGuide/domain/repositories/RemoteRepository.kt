package com.example.popularMoviesGuide.domain.repositories

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.example.popularMoviesGuide.domain.models.User

interface RemoteRepository {

    fun launchRegistrationScreen(launcher: ActivityResultLauncher<Intent>)

    fun updateUserData(user: User)

}