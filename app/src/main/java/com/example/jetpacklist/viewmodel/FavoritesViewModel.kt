package com.example.jetpacklist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jetpacklist.data.FavoriteData
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {
    private val _favorites = MutableLiveData<List<FavoriteData>>()
    val favorites: LiveData<List<FavoriteData>> = _favorites

    private fun loadFavorites(){
      try {
          val assetManager = getApplication<Application>().assets
          val inputStream = assetManager.open("favorites.json")
          val jsonString = inputStream.bufferedReader().use { it.readText() }
          val favorites = object : TypeToken<List<FavoriteData>>() {}.type
          _favorites.value = Gson().fromJson(jsonString, favorites)

      }catch (e:Exception){
          e.printStackTrace()
      }

    }
}