package com.example.jetpacklist.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.jetpacklist.R

@Composable
fun LandmarkDetailView(landmarkId: Int,landmarkName: String,description:String,airport:String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = stringResource(id = R.string.landmark_number) +landmarkId,style = MaterialTheme.typography.titleMedium)
        Text(text = landmarkName,style = MaterialTheme.typography.headlineLarge)
        Text(text = stringResource(id = R.string.description) + "\n $description", style = MaterialTheme.typography.bodyLarge)
        Text(text = "\n" + stringResource(id = R.string.airport) + airport, style = MaterialTheme.typography.bodySmall)
    }
}