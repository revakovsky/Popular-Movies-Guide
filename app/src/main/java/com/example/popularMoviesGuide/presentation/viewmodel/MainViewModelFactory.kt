package com.example.popularMoviesGuide.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.popularMoviesGuide.data.repository.RegisterScreenRepositoryImpl
import com.example.popularMoviesGuide.data.repository.UserDataRepositoryImpl
import com.example.popularMoviesGuide.domain.repositories.RegisterScreenRepository
import com.example.popularMoviesGuide.domain.repositories.UserDataRepository
import com.example.popularMoviesGuide.domain.usecase.OpenRegistrationScreenUseCase
import com.example.popularMoviesGuide.domain.usecase.UpdateUserDataUseCase

class MainViewModelFactory : ViewModelProvider.Factory {

    private val registerScreenRepository: RegisterScreenRepository = RegisterScreenRepositoryImpl()
    private val userDataRepository: UserDataRepository = UserDataRepositoryImpl()

    private val openRegistrationScreenUseCase =
        OpenRegistrationScreenUseCase(registerScreenRepository)

    private val updateUserDataUseCase =
        UpdateUserDataUseCase(userDataRepository)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(openRegistrationScreenUseCase, updateUserDataUseCase) as T
    }

}