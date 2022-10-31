package com.example.popularMoviesGuide.data.storage.sharedprefStorage

import android.content.Context
import androidx.core.content.edit
import com.example.popularMoviesGuide.data.models.DataUser
import com.example.popularMoviesGuide.data.storage.LocalStorage

private const val SHARED_PREF_USER = "sharedPref_user"
private const val SHARED_PREF_UID = "sharedPref_uId"

class SharedPrefStorage(context: Context) : LocalStorage {

    private val sharedPref = context.getSharedPreferences(SHARED_PREF_USER, Context.MODE_PRIVATE)

    override fun saveUid(dataUser: DataUser) {
        sharedPref.edit { putString(SHARED_PREF_UID, dataUser.uid) }
    }

    override fun getUid(): String {
        return sharedPref.getString(SHARED_PREF_UID, "").toString()
    }

}