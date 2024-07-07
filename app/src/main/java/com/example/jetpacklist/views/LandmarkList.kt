package com.example.jetpacklist.views


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
       items(landmarks.value.size) { index ->
           ListItem(landmark = landmarks.value[index])
       }
   }
}

    @Composable
    fun ListItem(landmark: LandmarkData) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = landmark.name,style = MaterialTheme.typography.headlineSmall)
            Text(text = landmark.description,style = MaterialTheme.typography.bodyLarge)
            }
        }


@Composable
fun LandmarkListView(name: String, modifier: Modifier) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
                .fillMaxWidth()
                .background(color = Color.LightGray)
                .padding(4.dp)
                .height(60.dp)
        )
        repeat(100) {
            Text(
                text = "Item $it : name $name",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(4.dp)
                    .height(48.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LandmarkListViewPreview() {
    JetpackListTheme {
        LandmarkListView("Android", modifier = Modifier)
    }
}

