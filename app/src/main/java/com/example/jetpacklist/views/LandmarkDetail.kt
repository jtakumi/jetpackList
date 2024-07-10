package com.example.jetpacklist.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class LandmarkDetail {
}

@Composable
fun LandmarkDetailView(landmarkId: Int,landmarkName: String,description:String,airport:String) {
    Column {
        Text(text = landmarkId.toString())
        Text(text = landmarkName)
        Text(text = description)
        Text(text = airport)
    }
}