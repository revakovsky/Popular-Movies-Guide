package com.example.popularMoviesGuide.domain.usecase

import com.example.popularMoviesGuide.domain.models.registering.User
import com.example.popularMoviesGuide.domain.repositories.RegisteringRepository

class SaveUserUidUseCase(
    private val registeringRepository: RegisteringRepository
) {

    fun invoke(user: User) {
        if (!user.isAnonymous) registeringRepository.saveUserUid(user)
    }

}