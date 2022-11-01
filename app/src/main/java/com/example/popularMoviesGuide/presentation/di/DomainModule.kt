package com.example.popularMoviesGuide.presentation.di

import com.example.popularMoviesGuide.domain.repositories.LocalRepository
import com.example.popularMoviesGuide.domain.repositories.RemoteRepository
import com.example.popularMoviesGuide.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideOpenRegistrationScreenUseCase(
        remoteRepository: RemoteRepository
    ): OpenRegistrationScreenUseCase {
        return OpenRegistrationScreenUseCase(remoteRepository)
    }

    @Provides
    fun provideUpdateUserDataUseCase(
        remoteRepository: RemoteRepository
    ): UpdateUserDataUseCase {
        return UpdateUserDataUseCase(remoteRepository)
    }

    @Provides
    fun provideSaveUserUidUseCase(
        localRepository: LocalRepository
    ): SaveUserUidUseCase {
        return SaveUserUidUseCase(localRepository)
    }

    @Provides
    fun provideGetUserUidUseCase(
        localRepository: LocalRepository
    ): GetUserUidUseCase {
        return GetUserUidUseCase(localRepository)
    }

    @Provides
    fun provideGetEnteringCounterUseCase(
        localRepository: LocalRepository
    ): GetEnteringCounterUseCase {
        return GetEnteringCounterUseCase(localRepository)
    }

    @Provides
    fun provideSaveEnteringCounterUseCase(
        localRepository: LocalRepository
    ): SaveEnteringCounterUseCase {
        return SaveEnteringCounterUseCase(localRepository)
    }

}