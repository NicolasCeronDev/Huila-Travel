package com.appsnicolas.huilatravel.data

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences("AuthPrefs", Context.MODE_PRIVATE)

    companion object {
        const val USER_ID = "USER_ID"
        const val USER_NAME = "USER_NAME"
        const val USER_EMAIL = "USER_EMAIL"
        const val IS_LOGGED_IN = "IS_LOGGED_IN"
    }

    fun saveAuthData(userId: String, userName: String, userEmail: String) {
        val editor = prefs.edit()
        editor.putString(USER_ID, userId)
        editor.putString(USER_NAME, userName)
        editor.putString(USER_EMAIL, userEmail)
        editor.putBoolean(IS_LOGGED_IN, true)
        editor.apply()
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean(IS_LOGGED_IN, false)
    }

    fun getUserId(): String? {
        return prefs.getString(USER_ID, null)
    }

    fun getUserName(): String? {
        return prefs.getString(USER_NAME, null)
    }

    fun getUserEmail(): String? {
        return prefs.getString(USER_EMAIL, null)
    }

    fun clearAuthData() {
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}
