package com.example.popularMoviesGuide.trash

/**
 * Repository saves the user's data to the Firebase Realtime Database
 */

interface FirebaseRepository {
    fun updateUserData(firebaseUser: User, uId: String)
}