package com.example.popularMoviesGuide.presentation.viewmodel.viewmodelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.popularMoviesGuide.domain.usecase.*
import com.example.popularMoviesGuide.presentation.viewmodel.MainViewModel

class MainViewModelFactory(
    private val openRegistrationScreenUseCase: OpenRegistrationScreenUseCase,
    private val updateUserDataUseCase: UpdateUserDataUseCase,
    private val saveUserUidUseCase: SaveUserUidUseCase,
    private val getUserUidUseCase: GetUserUidUseCase,
    private val getEnteringCounterUseCase: GetEnteringCounterUseCase,
    private val saveEnteringCounterUseCase: SaveEnteringCounterUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            openRegistrationScreenUseCase,
            updateUserDataUseCase,
            saveUserUidUseCase,
            getUserUidUseCase,
            getEnteringCounterUseCase,
            saveEnteringCounterUseCase
        ) as T
    }

}