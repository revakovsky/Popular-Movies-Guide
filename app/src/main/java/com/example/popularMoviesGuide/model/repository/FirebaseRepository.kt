package com.example.popularMoviesGuide.model.repository

import com.example.popularMoviesGuide.data.User

interface FirebaseRepository {
    fun updateUserData(firebaseUser: User, uId: String)
}