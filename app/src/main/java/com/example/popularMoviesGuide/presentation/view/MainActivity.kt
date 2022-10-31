package com.example.popularMoviesGuide.presentation.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.popularMoviesGuide.R
import com.example.popularMoviesGuide.databinding.ActivityMainBinding
import com.example.popularMoviesGuide.makeToast
import com.example.popularMoviesGuide.presentation.viewmodel.MainViewModel
import com.example.popularMoviesGuide.presentation.viewmodel.viewmodelFactory.MainViewModelFactory
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mainViewModel: MainViewModel
    private var isUidExist: Boolean = false

    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { resultCallback ->
        this.mainViewModel.onSignInResult(resultCallback)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel =
            ViewModelProvider(
                this, MainViewModelFactory(this)
            ).get(MainViewModel::class.java)

        isUidExist = mainViewModel.checkUid()

        chooseAction()
    }

    private fun chooseAction() {
        if (isUidExist) intentToNextScreen(MoviesActivity())
        else {
            mainViewModel.launchRegistrationScreen(signInLauncher)
            onRegisteringResult()
        }
    }

    private fun onRegisteringResult() {
        mainViewModel.isSuccessfulRegistering.observe(this) { result ->
            when (result) {
                true -> intentToNextScreen(MoviesActivity())

                false -> repeatRegistering()

                else -> {
                    intentToNextScreen(MoviesActivity())
                    makeToast(R.string.wrong_registering)
                }
            }
        }
    }

    private fun repeatRegistering() {
        binding.apply {
            repeatAuthButton.visibility = View.VISIBLE
            repeatAuthButton.setOnClickListener {
                mainViewModel.launchRegistrationScreen(signInLauncher)
                binding.repeatAuthButton.visibility = View.INVISIBLE
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (isUidExist) intentToNextScreen(MoviesActivity())
    }

    private fun intentToNextScreen(requiredActivity: AppCompatActivity) {
        val intent = Intent(this, requiredActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

}