package com.example.jetpacklist.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpacklist.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandmarkDetailView(landmarkId: Int,landmarkName: String,description:String,airport:String,navController: NavController) {
    CenterAlignedTopAppBar(
        title = {Text(text = stringResource(id = R.string.app_name), maxLines = 1, overflow = TextOverflow.Ellipsis)},
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        )
    )
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