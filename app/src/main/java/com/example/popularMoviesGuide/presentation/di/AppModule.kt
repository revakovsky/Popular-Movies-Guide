package com.example.popularMoviesGuide.presentation.di

import android.content.Context
import com.example.popularMoviesGuide.domain.usecase.*
import com.example.popularMoviesGuide.presentation.viewmodel.viewmodelFactory.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideContext(): Context = context

    @Provides
    fun provideMainViewModelFactory(
        openRegistrationScreenUseCase: OpenRegistrationScreenUseCase,
        updateUserDataUseCase: UpdateUserDataUseCase,
        saveUserUidUseCase: SaveUserUidUseCase,
        getUserUidUseCase: GetUserUidUseCase,
        getEnteringCounterUseCase: GetEnteringCounterUseCase,
        saveEnteringCounterUseCase: SaveEnteringCounterUseCase,
    ): MainViewModelFactory {

        return MainViewModelFactory(
            openRegistrationScreenUseCase,
            updateUserDataUseCase,
            saveUserUidUseCase,
            getUserUidUseCase,
            getEnteringCounterUseCase,
            saveEnteringCounterUseCase
        )
    }

    fun provideMoviesViewModelFactory() {

    }
}