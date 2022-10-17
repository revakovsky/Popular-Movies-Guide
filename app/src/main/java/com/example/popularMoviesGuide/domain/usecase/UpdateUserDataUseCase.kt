package com.example.popularMoviesGuide.domain.usecase

import com.example.popularMoviesGuide.domain.models.User
import com.example.popularMoviesGuide.domain.repositories.UserDataRepository

class UpdateUserDataUseCase(
    private val userDataRepository: UserDataRepository
) {

    fun invoke(user: User) {
        userDataRepository.updateUserData(user)
    }

}