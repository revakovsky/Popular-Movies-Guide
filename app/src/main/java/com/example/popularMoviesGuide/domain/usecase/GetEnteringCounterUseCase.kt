package com.example.popularMoviesGuide.domain.usecase

import com.example.popularMoviesGuide.domain.repositories.LocalRepository

class GetEnteringCounterUseCase(
    private val localRepository: LocalRepository
) {

    fun invoke(): Int {
        return localRepository.getUserEnteringCounter()
    }

}