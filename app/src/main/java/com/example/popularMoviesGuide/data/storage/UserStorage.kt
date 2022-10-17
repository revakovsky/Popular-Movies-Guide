package com.example.popularMoviesGuide.data.storage

import com.example.popularMoviesGuide.data.models.FirebaseUser

interface UserStorage {

    fun updateData(firebaseUser: FirebaseUser)

}