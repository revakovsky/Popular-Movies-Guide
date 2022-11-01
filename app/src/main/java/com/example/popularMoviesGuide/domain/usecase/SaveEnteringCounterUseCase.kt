package com.example.popularMoviesGuide.domain.usecase

import com.example.popularMoviesGuide.domain.repositories.LocalRepository

class SaveEnteringCounterUseCase(
    private val localRepository: LocalRepository
) {

    private val amountAnonymousSessions: Int = 2
    private var enteringCounter: Int = 0

    fun invoke() {
        enteringCounter = localRepository.getUserEnteringCounter()

        if (enteringCounter < amountAnonymousSessions) {
            enteringCounter++
            localRepository.saveUserEnteringCounter(enteringCounter)
        } else {
            enteringCounter = 0
            localRepository.saveUserEnteringCounter(enteringCounter)
        }
    }

}