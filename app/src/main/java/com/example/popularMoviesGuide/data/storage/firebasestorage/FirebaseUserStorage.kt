package com.example.popularMoviesGuide.data.storage.firebasestorage

import com.example.popularMoviesGuide.data.models.FirebaseUser
import com.example.popularMoviesGuide.data.storage.UserStorage
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirebaseUserStorage : UserStorage {

    override fun updateData(firebaseUser: FirebaseUser) {
        val database: DatabaseReference = Firebase.database.reference
        val uId = firebaseUser.uid
        database.child("users").child(uId).setValue(firebaseUser)
    }

}