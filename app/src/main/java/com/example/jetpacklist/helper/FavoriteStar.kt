package com.example.jetpacklist.helper


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.jetpacklist.R

@Composable
fun FavoriteStar(isFavoriteData: Boolean) {
    var isFavoriteDetail by remember {
        mutableStateOf(isFavoriteData)
    }

    IconButton(onClick = { isFavoriteDetail = !isFavoriteDetail }, modifier = Modifier.background(color = androidx.compose.ui.graphics.Color.Transparent)) {
        when(isFavoriteDetail){
            true -> Image(painter = painterResource(id = R.drawable.fav_star_filled), contentDescription = "favorite")
        else -> Image(painter = painterResource(id = R.drawable.fav_star_outlined), contentDescription = "not favorite")
        }

    }
}