package com.example.popularMoviesGuide.data.storage.firebaseStorage

import com.example.popularMoviesGuide.data.models.DataUser
import com.example.popularMoviesGuide.data.storage.UserStorage
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirebaseUserStorage : UserStorage {

    override fun updateData(dataUser: DataUser) {
        val database: DatabaseReference = Firebase.database.reference
        val uId = dataUser.uid
        database.child("users").child(uId).setValue(dataUser)
    }

}