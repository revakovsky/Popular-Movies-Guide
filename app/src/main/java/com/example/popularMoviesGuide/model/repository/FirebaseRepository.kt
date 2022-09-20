package com.example.popularMoviesGuide.model.repository

import com.example.popularMoviesGuide.data.User

/**
 * Repository saves the user's data to the Firebase Realtime Database
 */

interface FirebaseRepository {
    fun updateUserData(firebaseUser: User, uId: String)
}