package com.example.popularMoviesGuide.presentation.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.popularMoviesGuide.R
import com.example.popularMoviesGuide.databinding.ActivityMainBinding
import com.example.popularMoviesGuide.makeToast
import com.example.popularMoviesGuide.presentation.app.App
import com.example.popularMoviesGuide.presentation.viewmodel.MainViewModel
import com.example.popularMoviesGuide.presentation.viewmodel.viewmodelFactory.MainViewModelFactory
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var binding: ActivityMainBinding

    private lateinit var mainViewModel: MainViewModel
    private var isUidExist: Boolean = false
    private var enteringCounter: Int = 0

    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { resultCallback ->
        this.mainViewModel.onSignInResult(resultCallback)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)

        initValues()
        chooseAction()
    }

    private fun initValues() {
        mainViewModel =
            ViewModelProvider(
                this, viewModelFactory)
                .get(MainViewModel::class.java)

        isUidExist = mainViewModel.checkUid()
        enteringCounter = mainViewModel.getEnteringCounter()
    }

    private fun chooseAction() {
        if (isUidExist) intentToNextScreen(MoviesActivity())
        else if (enteringCounter == 0) launchRegistration()
        else launchAnonymousSession()
    }

    private fun launchRegistration() {
        mainViewModel.launchRegistrationScreen(signInLauncher)
        onRegisteringResult()
    }

    private fun launchAnonymousSession() {
        mainViewModel.saveEnteringCounter()
        intentToNextScreen(MoviesActivity())
    }

    private fun onRegisteringResult() {
        mainViewModel.isSuccessfulRegistering.observe(this) { result ->
            when (result) {
                true -> intentToNextScreen(MoviesActivity())

                false -> showRepeatButton()

                else -> {
                    intentToNextScreen(MoviesActivity())
                    makeToast(R.string.wrong_registering)
                }
            }
        }
    }

    private fun showRepeatButton() {
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