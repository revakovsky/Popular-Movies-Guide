package com.example.popularMoviesGuide.data.storage.sharedprefStorage

import android.content.Context
import androidx.core.content.edit
import com.example.popularMoviesGuide.data.models.registering.DataUser
import com.example.popularMoviesGuide.data.storage.LocalStorage

class SharedPrefStorage(context: Context) : LocalStorage {

    private val sharedPref = context.getSharedPreferences(SHARED_PREF_USER, Context.MODE_PRIVATE)

    override fun saveUid(user: DataUser) {
        sharedPref.edit { putString(SHARED_PREF_UID, user.uid) }
    }

    override fun getUid(): String {
        return sharedPref.getString(SHARED_PREF_UID, "").toString()
    }

    override fun saveEnteringCounter(counter: Int) {
        sharedPref.edit { putInt(SHARED_PREF_ENTERING_COUNTER, counter) }
    }

    override fun getEnteringCounter(): Int {
        return sharedPref.getInt(SHARED_PREF_ENTERING_COUNTER, 0)
    }

    companion object {
        private const val SHARED_PREF_USER = "sharedPref_user"
        private const val SHARED_PREF_UID = "sharedPref_uId"
        private const val SHARED_PREF_ENTERING_COUNTER = "entering_counter"
    }

}