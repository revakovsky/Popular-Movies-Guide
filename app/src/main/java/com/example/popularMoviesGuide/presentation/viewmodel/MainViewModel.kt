package com.example.popularMoviesGuide.presentation.viewmodel

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.popularMoviesGuide.domain.models.User
import com.example.popularMoviesGuide.domain.usecase.GetUserUidUseCase
import com.example.popularMoviesGuide.domain.usecase.OpenRegistrationScreenUseCase
import com.example.popularMoviesGuide.domain.usecase.SaveUserUidUseCase
import com.example.popularMoviesGuide.domain.usecase.UpdateUserDataUseCase
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth

class MainViewModel(
    private val openRegistrationScreenUseCase: OpenRegistrationScreenUseCase,
    private val updateUserDataUseCase: UpdateUserDataUseCase,
    private val saveUserUidUseCase: SaveUserUidUseCase,
    private val getUserUidUseCase: GetUserUidUseCase
) : ViewModel() {

    private val _isSuccessfulRegistering = MutableLiveData<Boolean>()
    val isSuccessfulRegistering: LiveData<Boolean> = _isSuccessfulRegistering

    fun checkUid(): Boolean {
        val userUid = getUserUidUseCase.invoke()
        return userUid.isNotBlank()
    }

    fun launchRegistrationScreen(launcher: ActivityResultLauncher<Intent>) {
        openRegistrationScreenUseCase.invoke(launcher)
    }

    fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        when (result.resultCode) {
            AppCompatActivity.RESULT_OK -> prepareSession()

            AppCompatActivity.RESULT_CANCELED -> _isSuccessfulRegistering.value = false

            else -> _isSuccessfulRegistering.value = false
        }
    }

    private fun prepareSession() {
        val authenticatedUser: User = getAuthenticatedUser()

        saveUserUidUseCase.invoke(authenticatedUser)

        updateUserDataUseCase.invoke(
            User(
                authenticatedUser.email,
                authenticatedUser.uid,
                authenticatedUser.name,
                authenticatedUser.isAnonymous
            )
        )
        _isSuccessfulRegistering.value = true
    }

    private fun getAuthenticatedUser(): User {
        val authenticatedUser = FirebaseAuth.getInstance().currentUser

        val email: String = authenticatedUser?.email.toString()
        val uid: String = authenticatedUser?.uid.toString()
        val name: String = authenticatedUser?.displayName.toString()
        val isAnonymous: Boolean = authenticatedUser?.isAnonymous == true

        return User(email, uid, name, isAnonymous)
    }

}