package com.example.popularMoviesGuide.model.repository

import com.example.popularMoviesGuide.data.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirebaseRepositoryImpl : FirebaseRepository{

    private var database: DatabaseReference = Firebase.database.reference

    override fun updateUserData(firebaseUser: User, uId: String) {
        database.child("users").child(uId).setValue(firebaseUser)

    }
}