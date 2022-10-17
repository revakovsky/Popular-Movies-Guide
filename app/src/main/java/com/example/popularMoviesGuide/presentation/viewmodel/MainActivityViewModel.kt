package com.example.popularMoviesGuide.presentation.viewmodel

import android.content.Intent
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.popularMoviesGuide.R
import com.example.popularMoviesGuide.domain.models.User
import com.example.popularMoviesGuide.domain.usecase.OpenRegistrationScreenUseCase
import com.example.popularMoviesGuide.domain.usecase.UpdateUserDataUseCase
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth

class MainActivityViewModel(
    private val openRegistrationScreenUseCase: OpenRegistrationScreenUseCase,
    private val updateUserDataUseCase: UpdateUserDataUseCase
) : ViewModel() {

    private val _isSuccessfulRegistering = MutableLiveData<List<Int>>()
    val isSuccessfulRegistering: LiveData<List<Int>> = _isSuccessfulRegistering

    fun launchRegistrationScreen(launcher: ActivityResultLauncher<Intent>) {
        openRegistrationScreenUseCase.invoke(launcher)
    }

    fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        when (result.resultCode) {

            AppCompatActivity.RESULT_OK -> {
                val authenticatedUser = FirebaseAuth.getInstance().currentUser
                authenticatedUser?.let {
                    val email = it.email.toString()
                    val uid = it.uid
                    val name = it.displayName
                    val isAnonymous = it.isAnonymous

                    updateUserDataUseCase.invoke(User(email, uid))

                    Log.d("TAG", "onSignInResult: ${result.resultCode} and ${result.idpResponse}")

                    _isSuccessfulRegistering.value =
                        listOf(AppCompatActivity.RESULT_OK, R.string.success_registering)
                }
            }

            AppCompatActivity.RESULT_CANCELED -> {
                _isSuccessfulRegistering.value =
                    listOf(AppCompatActivity.RESULT_CANCELED, R.string.wrong_registering)
            }

            else -> {
                // todo make an action for this type of registering error
                Log.d("TAG", "onSignInResult: ${result.resultCode} and ${result.idpResponse}")
            }
        }
    }
}