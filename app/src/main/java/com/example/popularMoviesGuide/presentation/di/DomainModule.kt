package com.example.popularMoviesGuide.presentation.di

import com.example.popularMoviesGuide.domain.repositories.LocalRepository
import com.example.popularMoviesGuide.domain.repositories.RegisteringRepository
import com.example.popularMoviesGuide.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideOpenRegistrationScreenUseCase(
        registeringRepository: RegisteringRepository
    ): OpenRegistrationScreenUseCase {
        return OpenRegistrationScreenUseCase(registeringRepository)
    }

    @Provides
    fun provideUpdateUserDataUseCase(
        registeringRepository: RegisteringRepository
    ): UpdateUserDataUseCase {
        return UpdateUserDataUseCase(registeringRepository)
    }

    @Provides
    fun provideSaveUserUidUseCase(
        registeringRepository: RegisteringRepository
    ): SaveUserUidUseCase {
        return SaveUserUidUseCase(registeringRepository)
    }

    @Provides
    fun provideGetUserUidUseCase(
        registeringRepository: RegisteringRepository
    ): GetUserUidUseCase {
        return GetUserUidUseCase(registeringRepository)
    }

    @Provides
    fun provideGetEnteringCounterUseCase(
        registeringRepository: RegisteringRepository
    ): GetEnteringCounterUseCase {
        return GetEnteringCounterUseCase(registeringRepository)
    }

    @Provides
    fun provideSaveEnteringCounterUseCase(
        registeringRepository: RegisteringRepository
    ): SaveEnteringCounterUseCase {
        return SaveEnteringCounterUseCase(registeringRepository)
    }

}