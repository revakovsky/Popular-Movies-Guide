package com.example.popularMoviesGuide.domain.usecase

import com.example.popularMoviesGuide.domain.repositories.RegisteringRepository

class GetUserUidUseCase(
    private val registeringRepository: RegisteringRepository
) {

    fun invoke(): String {
        return registeringRepository.getUserUid()
    }

}