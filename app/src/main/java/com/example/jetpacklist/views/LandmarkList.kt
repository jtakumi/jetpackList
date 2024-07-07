package com.example.jetpacklist.views


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpacklist.data.LandmarkData
import com.example.jetpacklist.ui.theme.JetpackListTheme
import com.example.jetpacklist.viewmodel.LandmarkViewModel


@Composable
fun LandmarkList(viewModel: LandmarkViewModel) {
    val landmarks = viewModel.landmarks.observeAsState(initial = emptyList())
   LazyColumn {
       item { Spacer(modifier = Modifier.padding(24.dp))}
       item { Text(text = "Landmarks", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.headlineLarge) }
       items(landmarks.value.size) { index ->
           ListItem(landmark = landmarks.value[index])
       }
       item { Spacer(modifier = Modifier.padding(24.dp))}
   }
}

    @Composable
    fun ListItem(landmark: LandmarkData) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray)
            .padding(16.dp)) {
            Text(text = landmark.name,style = MaterialTheme.typography.headlineSmall)
            Text(text = landmark.description,style = MaterialTheme.typography.bodyLarge)
            }
        }

@Preview(showBackground = true)
@Composable
fun ListItemPreview() {
   JetpackListTheme {
       ListItem(landmark = LandmarkData(1, "landmark ex", "this is sample."))
   }
}


