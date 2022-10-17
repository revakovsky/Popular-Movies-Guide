package com.example.popularMoviesGuide.presentation.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.popularMoviesGuide.R
import com.example.popularMoviesGuide.makeToast
import com.example.popularMoviesGuide.presentation.viewmodel.MainActivityViewModel
import com.example.popularMoviesGuide.presentation.viewmodel.MainViewModelFactory
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel

    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { resultCallback ->
        this.mainActivityViewModel.onSignInResult(resultCallback)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel =
            ViewModelProvider(this, MainViewModelFactory()).get(MainActivityViewModel::class.java)

        mainActivityViewModel.launchRegistrationScreen(signInLauncher)
        subscribeToSignInLiveData()
    }

    private fun subscribeToSignInLiveData() {
        mainActivityViewModel.isSuccessfulRegistering.observe(this, Observer { list ->
            val resultCode = list[0]
            val resultMessage = list[1]

            when (resultCode) {
                RESULT_OK -> doMakeIntent(true, resultMessage)

                RESULT_CANCELED -> doMakeIntent(false, resultMessage)

                else -> doMakeIntent(true, resultMessage)
            }
        })
    }

    private fun doMakeIntent(addIntent: Boolean, message: Int) {
        when (addIntent) {
            true -> {
                makeToast(message)
                intentToAnotherScreen(MoviesActivity())
            }
            false -> {
                makeToast(message)
                finishAffinity()
            }
        }
    }

    private fun intentToAnotherScreen(requiredActivity: AppCompatActivity) {
        val intent = Intent(this, requiredActivity::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

}
