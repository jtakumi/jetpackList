package com.example.jetpacklist.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpacklist.ui.theme.JetpackListTheme

class LandmarkList(name: String, modifier: Modifier) {

    @Composable
    fun ListView(name: String, modifier: Modifier = Modifier) {
       ListItem()
    }
}


    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        JetpackListTheme {
            Greeting("Android")
        }
    }
