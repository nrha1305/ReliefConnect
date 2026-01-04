package com.reliefconnect.app.data

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "auth_prefs")

class DataStoreManager(private val context: Context) {

    companion object {
        val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
    }

    val isLoggedIn: Flow<Boolean> = context.dataStore.data
        .map { prefs ->
            prefs[IS_LOGGED_IN] ?: false
        }

    suspend fun saveLoginState(isLoggedIn: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[IS_LOGGED_IN] = isLoggedIn
        }
    }
}
