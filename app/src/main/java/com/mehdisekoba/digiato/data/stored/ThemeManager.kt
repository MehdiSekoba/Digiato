package com.mehdisekoba.digiato.data.stored

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.mehdisekoba.digiato.utils.DARK_STATUS
import com.mehdisekoba.digiato.utils.SETTINGS_DATA
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ThemeManager @Inject constructor(
    @ApplicationContext private val context: Context,
) {
    private val appContext = context.applicationContext
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(SETTINGS_DATA)
        private val DARK_STATUS_KEY  = booleanPreferencesKey(DARK_STATUS)
    }


    suspend fun saveTheme(isDarkTheme: Boolean) {
        appContext.dataStore.edit {
            it[DARK_STATUS_KEY] = isDarkTheme
        }
    }


    val isDarkTheme: Flow<Boolean> =
        appContext.dataStore.data.map { preferences ->
            preferences[DARK_STATUS_KEY] ?: false
        }


}
