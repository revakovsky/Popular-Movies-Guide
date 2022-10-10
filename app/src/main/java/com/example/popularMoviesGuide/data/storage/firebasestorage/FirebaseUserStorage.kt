package com.example.popularMoviesGuide.data.storage.firebasestorage

import com.example.popularMoviesGuide.data.storage.UserStorage
import com.example.popularMoviesGuide.data.storage.models.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirebaseUserStorage : UserStorage {

    private var database: DatabaseReference = Firebase.database.reference

    override fun updateData(user: FirebaseUser) {
        val uId = user.uid
        database.child("users").child(uId).setValue(user)
    }

}