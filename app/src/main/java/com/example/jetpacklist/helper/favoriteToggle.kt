package com.example.jetpacklist.helper

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
    var isFavorite by remember { mutableStateOf(false) }
    var isChecked by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        // DataStore からデータを取得する
        // スマホを横向きにしても、タスクキルしても状態が残るようにする
        isFavorite = viewModel.readToggleState(context)
        isChecked = isFavorite
    }

    Switch(
        checked = isChecked,
        onCheckedChange = { checked -> isChecked = checked
                          coroutineScope.launch {
                              //非同期で状態を保存
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
