package com.example.jetpacklist.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LandmarkDetailView(landmarkId: Int,landmarkName: String,description:String,airport:String) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "観光地番号No.${landmarkId}",style = MaterialTheme.typography.titleMedium)
        Text(text = landmarkName,style = MaterialTheme.typography.headlineLarge)
        Text(text = "おすすめポイントやスポットなど\n $description", style = MaterialTheme.typography.bodyLarge)
        Text(text = "\n観光地から最寄りの空港:${airport}", style = MaterialTheme.typography.bodySmall)
    }
}