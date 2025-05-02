package com.example.jetpacklist.views

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpacklist.R
import com.example.jetpacklist.ui.theme.JetpackListTheme

@Composable
fun LandmarkListCell(
    landmarkName: String,
    landmarkImage: Int,
    isFavorite: Boolean,
    onFavoriteToggle: () -> Unit
) {
    JetpackListTheme {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            Text(
                text = landmarkName,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 16.dp, bottom = 8.dp, top = 8.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painterResource(landmarkImage),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 8.dp, top = 4.dp, bottom = 4.dp)
                    .clip(shape = CircleShape)
            )
        }
    }
}

@Preview(name = "Night Mode", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Preview(name = "Light Mode", showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun LandmarkListCellPreview() {
    JetpackListTheme {
        LandmarkListCell(
            landmarkName = "the city",
            landmarkImage = R.drawable.the_city_image,
            isFavorite = true,
            onFavoriteToggle = {}
        )
    }
}