package com.example.popularMoviesGuide.domain.usecase

import com.example.popularMoviesGuide.domain.models.User
import com.example.popularMoviesGuide.domain.repositories.LocalRepository

class SaveUserUidUseCase(
    private val localRepository: LocalRepository
) {

    fun invoke(user: User) {
        localRepository.saveUserUid(user)
    }

}