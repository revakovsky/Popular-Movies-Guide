package com.example.popularMoviesGuide.data.storage

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.example.popularMoviesGuide.data.models.registering.DataUser

interface AuthStorage {

    fun launchRegistrationScreen(launcher: ActivityResultLauncher<Intent>)

    fun updateData(user: DataUser)

}