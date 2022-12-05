package com.example.popularMoviesGuide.domain.repositories

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.example.popularMoviesGuide.domain.models.registering.User

interface RegisteringRepository {

    fun launchRegistrationScreen(launcher: ActivityResultLauncher<Intent>)

    fun updateUserData(user: User)

    fun saveUserUid(user: User)

    fun getUserUid(): String

    fun saveUserEnteringCounter(counter: Int)

    fun getUserEnteringCounter(): Int

}
