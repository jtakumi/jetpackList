package com.example.jetpacklist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import com.example.jetpacklist.ui.theme.JetpackListTheme
import com.example.jetpacklist.viewmodel.LandmarkViewModel
import com.example.jetpacklist.views.LandmarkList


class MainActivity : ComponentActivity() {

    private val LandmarkViewModel: LandmarkViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackListTheme {
                Surface {
                    LandmarkList(viewModel = LandmarkViewModel)
                }
            }
        }
    }
}

