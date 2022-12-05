package com.example.popularMoviesGuide.domain.usecase

import com.example.popularMoviesGuide.domain.repositories.RegisteringRepository

class SaveEnteringCounterUseCase(
    private val registeringRepository: RegisteringRepository
) {

    private val amountAnonymousSessions: Int = 2
    private var enteringCounter: Int = 0

    fun invoke() {
        enteringCounter = registeringRepository.getUserEnteringCounter()

        if (enteringCounter < amountAnonymousSessions) {
            enteringCounter++
            registeringRepository.saveUserEnteringCounter(enteringCounter)
        } else {
            enteringCounter = 0
            registeringRepository.saveUserEnteringCounter(enteringCounter)
        }
    }

}