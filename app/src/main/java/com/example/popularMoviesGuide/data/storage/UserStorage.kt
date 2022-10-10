package com.example.popularMoviesGuide.data.storage

import com.example.popularMoviesGuide.data.storage.models.FirebaseUser

interface UserStorage {

    fun updateData(user: FirebaseUser)

}