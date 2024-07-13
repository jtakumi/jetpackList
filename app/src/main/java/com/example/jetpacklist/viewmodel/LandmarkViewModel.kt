package com.example.jetpacklist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jetpacklist.data.LandmarkData
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.io.InputStreamReader

class LandmarkViewModel(application: Application) : AndroidViewModel(application) {
    private val _landmarks = MutableLiveData<List<LandmarkData>>()
    val landmarks: LiveData<List<LandmarkData>> = _landmarks

    init {
        loadLandmarks()
    }

    private fun loadLandmarks() {
        val assetManager = getApplication<Application>().assets
        val inputStream = assetManager.open("Landmarks_ja.json")
        val jsonString =InputStreamReader(inputStream).use { it.readText() }
        val landmarks =object : TypeToken<List<LandmarkData>>() {}.type
        _landmarks.value = Gson().fromJson(jsonString, landmarks)
    }

}