package com.example.popularMoviesGuide.domain.usecase

import com.example.popularMoviesGuide.domain.models.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class UpdateUserDataUseCase {

    private var database: DatabaseReference = Firebase.database.reference

    fun updateData(firebaseUser: FirebaseUser, uId: String) {
        database.child("users").child(uId).setValue(firebaseUser)
    }

}