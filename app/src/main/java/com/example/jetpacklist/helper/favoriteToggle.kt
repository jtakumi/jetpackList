package com.example.jetpacklist.helper

import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun favoriteToggle(): Boolean {
    var isFavorite by remember {
        mutableStateOf(false)
    }
    Switch(
        checked = isFavorite,
        onCheckedChange = { isChecked -> isFavorite = isChecked },
        colors = SwitchDefaults.colors(
            checkedThumbColor = MaterialTheme.colorScheme.primary,
            checkedTrackColor =MaterialTheme.colorScheme.primaryContainer,
            uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
            uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer
        )
    )
    Log.d("jetpackList", "favoriteToggle: $isFavorite")
    return isFavorite
}
