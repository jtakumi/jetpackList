package com.example.jetpacklist.helper

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpacklist.viewmodel.LandmarkViewModel
import kotlinx.coroutines.launch

@Composable
fun favoriteToggle(viewModel: LandmarkViewModel = viewModel()): Boolean {
    val context = LocalContext.current
    val isFavorite by viewModel.readToggleState(context).collectAsState(initial =false)
    var isChecked by remember { mutableStateOf(isFavorite) }

    val coroutineScope = rememberCoroutineScope()

    Switch(
        checked = isChecked,
        onCheckedChange = { checked -> isChecked = checked
                          coroutineScope.launch {
                              viewModel.saveToggleState(context,checked)
                          }
                          },
        colors = SwitchDefaults.colors(
            checkedThumbColor = MaterialTheme.colorScheme.primary,
            checkedTrackColor =MaterialTheme.colorScheme.primaryContainer,
            uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
            uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer
        )
    )
    return isChecked
}
