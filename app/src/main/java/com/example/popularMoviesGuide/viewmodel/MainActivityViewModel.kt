package com.example.popularMoviesGuide.viewmodel

import com.example.popularMoviesGuide.data.User
import com.example.popularMoviesGuide.model.repository.FirebaseRepository
import com.example.popularMoviesGuide.model.repository.FirebaseRepositoryImpl

class MainActivityViewModel {
    private val firebaseRepository : FirebaseRepository = FirebaseRepositoryImpl()

    fun updateUserData(firebaseUser: User, uId: String) {
        firebaseRepository.updateUserData(firebaseUser, uId)
    }
}