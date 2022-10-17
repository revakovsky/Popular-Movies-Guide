package com.example.popularMoviesGuide.data.storage

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher

interface AuthStorage {

    fun launchRegistrationScreen(launcher: ActivityResultLauncher<Intent>)

}