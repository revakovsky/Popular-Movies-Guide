package com.example.popularMoviesGuide.domain.usecase

import com.example.popularMoviesGuide.domain.repositories.LocalRepository

class GetUserUidUseCase(
    private val localRepository: LocalRepository
) {

    fun invoke(): String {
        return localRepository.getUserUid()
    }

}