package com.example.popularMoviesGuide.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.popularMoviesGuide.R
import com.example.popularMoviesGuide.data.User
import com.example.popularMoviesGuide.viewmodel.MainActivityViewModel
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel : MainActivityViewModel = MainActivityViewModel()

    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { resultCallback ->
        this.onSignInResult(resultCallback)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openRegistrationScreen()
    }

    private fun openRegistrationScreen() {
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

    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        when (result.resultCode) {
            RESULT_OK -> {
                val authenticatedUser = FirebaseAuth.getInstance().currentUser
                authenticatedUser?.let {
                    val email = it.email.toString()
                    val uid = it.uid
                    val firebaseUser = User(email, uid)

                    mainActivityViewModel.updateUserData(firebaseUser, uid)

                    val intentToAnotherScreen = Intent(this, MoviesActivity::class.java)
                    startActivity(intentToAnotherScreen)
                }
            }
            RESULT_CANCELED -> {
                Toast.makeText(this@MainActivity, "something wrong with registration!", Toast.LENGTH_LONG).show()
            }
            else -> {
                // do not anything
            }
        }
    }
}
