package com.example.popularMoviesGuide.data.storage

import com.example.popularMoviesGuide.data.models.DataUser

interface LocalStorage {

    fun saveUid(dataUser: DataUser)

    fun getUid(): String

}