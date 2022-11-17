package com.example.popularMoviesGuide.data.storage

import com.example.popularMoviesGuide.data.models.registering.DataUser

interface LocalStorage {

    fun saveUid(user: DataUser)

    fun getUid(): String

    fun saveEnteringCounter(counter: Int)

    fun getEnteringCounter(): Int

}