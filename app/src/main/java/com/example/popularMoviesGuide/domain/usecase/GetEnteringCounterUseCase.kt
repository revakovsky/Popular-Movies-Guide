package com.example.popularMoviesGuide.domain.usecase

import com.example.popularMoviesGuide.domain.repositories.RegisteringRepository

class GetEnteringCounterUseCase(
    private val registeringRepository: RegisteringRepository
) {

    fun invoke(): Int {
        return registeringRepository.getUserEnteringCounter()
    }

}