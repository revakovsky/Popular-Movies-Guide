package com.example.popularMoviesGuide.domain.usecase

import com.example.popularMoviesGuide.domain.models.User
import com.example.popularMoviesGuide.domain.repositories.RemoteRepository

class UpdateUserDataUseCase(
    private val remoteRepository: RemoteRepository
) {

    fun invoke(user: User) {
        if (!user.isAnonymous) remoteRepository.updateUserData(user)
    }

}