package com.example.popularMoviesGuide.data.storage

import com.example.popularMoviesGuide.data.models.DataUser

interface UserStorage {

    fun updateData(dataUser: DataUser)

}