package com.example.jetpacklist

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.compose.rememberNavController
import com.example.jetpacklist.ui.theme.JetpackListTheme
import com.example.jetpacklist.viewmodel.LandmarkViewModel
import com.example.jetpacklist.views.SetLandmarkView

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "UserPreferences")

class MainActivity : ComponentActivity() {

    private val landmarkViewModel: LandmarkViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackListTheme {
                Surface {
                    val navController = rememberNavController()
                    SetLandmarkView(landmarkViewModel,navController = navController)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()
    }
}

