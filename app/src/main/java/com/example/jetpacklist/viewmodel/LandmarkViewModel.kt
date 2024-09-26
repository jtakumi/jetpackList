package com.example.jetpacklist.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jetpacklist.data.FavoriteData
import com.example.jetpacklist.data.LandmarkData
import com.example.jetpacklist.enum.getDefaultLanguage
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.util.Locale

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "UserPreferences")

class LandmarkViewModel(application: Application) : AndroidViewModel(application) {
    private val _landmarks = MutableLiveData<List<LandmarkData>>()
    val landmarks: LiveData<List<LandmarkData>> = _landmarks
    private val _favorites = MutableLiveData<List<FavoriteData>>()
    val favorites: LiveData<List<FavoriteData>> = _favorites
    private lateinit var currentLanguage:String

    init {
        loadLandmarks()
        loadFavorites()
    }
    fun reStartApp(){
        if(currentLanguage != getLocalizeJSONFileName()){
            loadLandmarks()
            loadFavorites() 
        }
    }

    fun readToggleState(context: Context): Flow<Boolean> {
        val toggleKey = booleanPreferencesKey("TOGGLE_KEY")
        return context.dataStore.data.map {
            preferences -> preferences[toggleKey] ?: false
        }
    }
    suspend fun convertFlowBooleanToBoolean(flow: Flow<Boolean>): Boolean {
        return flow.first()
    }

     suspend fun saveToggleState(context: Context, isChecked: Boolean) {
         val toggleKey = booleanPreferencesKey("TOGGLE_KEY")
         context.dataStore.edit { preferences ->
             preferences[toggleKey] = isChecked
         }
     }

     private fun loadLandmarks() {
        try {
            val assetManager = getApplication<Application>().assets
            currentLanguage = getLocalizeJSONFileName()
            val inputStream = assetManager.open(currentLanguage)
            val jsonString =inputStream.bufferedReader().use { it.readText() }
            val landmarks =object : TypeToken<List<LandmarkData>>() {}.type
            _landmarks.value = Gson().fromJson(jsonString, landmarks)
        } catch (e: Exception){
            e.printStackTrace()
        }
    }
    private fun getLocalizeJSONFileName():String {
        val locale = Locale.getDefault()
        val language = locale.language
        Log.d("jetpackList",language)
       return getDefaultLanguage(language)
    }
    //お気に入りデータは言語が変わっても同じように表示させる
    private fun loadFavorites() {
        try {
            val assetManager = getApplication<Application>().assets
            val inputStream = assetManager.open("Favorites.json")
            val jsonString = inputStream.bufferedReader().use { it.readText() }
            val favorites = object : TypeToken<List<FavoriteData>>() {}.type
            _favorites.value = Gson().fromJson(jsonString, favorites)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}