package com.example.jetpacklist.views


import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.jetpacklist.R
import com.example.jetpacklist.data.LandmarkData
import com.example.jetpacklist.helper.FavoriteStar
import com.example.jetpacklist.helper.favoriteToggle
import com.example.jetpacklist.ui.theme.JetpackListTheme
import com.example.jetpacklist.viewmodel.LandmarkViewModel


private var isOnFavoriteToggle = false

sealed class Destination(val route: String) {
    data object Landmarks : Destination("landmarks")
    data object LandmarkDetail : Destination("landmark_detail/{landmarkId}/{landmarkName}/{description}/{airport}"){
        fun createRoute(landmark: LandmarkData) = "landmark_detail/${landmark.id}/${landmark.name}/${landmark.description}/${landmark.airport}"
    }
}

@Composable
fun SetLandmarkView(landmarkViewModel: LandmarkViewModel,navController: NavHostController){
    NavHost(navController = navController, startDestination = Destination.Landmarks.route) {
        composable(Destination.Landmarks.route) {
            LandmarkList(viewModel = landmarkViewModel,navController)
        }
        composable(route = Destination.LandmarkDetail.route,
            arguments = listOf(
                navArgument("landmarkId") {type = NavType.IntType},
                navArgument("landmarkName") {type = NavType.StringType},
                navArgument("description"){type = NavType.StringType},
                navArgument("airport"){type = NavType.StringType},
            )
        )
        { backStackEntry ->
            val landmarkId = backStackEntry.arguments?.getInt("landmarkId") ?: 0
            val landmarkName = backStackEntry.arguments?.getString("landmarkName") ?: ""
            val description = backStackEntry.arguments?.getString("description") ?: ""
            val airport = backStackEntry.arguments?.getString("airport") ?: ""
            LandmarkDetailView(
                landmarkId=landmarkId,
                landmarkName=landmarkName,
                description=description,
                airport=airport,
                navController = navController
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandmarkList(viewModel: LandmarkViewModel,navController: NavController) {
    val landmarks = viewModel.landmarks.observeAsState(initial = emptyList())
    val favoriteDataList = viewModel.favorites.observeAsState(initial = emptyList())
    Column {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.app_name),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary
            )
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Text(text = stringResource(id = R.string.favoriteTitle), style = MaterialTheme.typography.bodyLarge)
            // 中央のスペースを開けるためのスペーサー
            Spacer(modifier = Modifier.weight(1f))
            isOnFavoriteToggle = favoriteToggle(viewModel)
        }
        
        LazyColumn {
            items(landmarks.value.size) { index ->
                if (isOnFavoriteToggle.not() || favoriteDataList.value[index].isFavorite) {
                        ListItem(landmark = landmarks.value[index],favoriteData=favoriteDataList.value[index].isFavorite, navController = navController)
                }
            }
            item { Spacer(modifier = Modifier.padding(24.dp)) }
        }
    }
}

    @Composable
    fun ListItem(landmark: LandmarkData, favoriteData:Boolean, navController: NavController) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate(route = Destination.LandmarkDetail.createRoute(landmark))
            }
            .border(1.dp, Color.Gray)
            .padding(16.dp)) {
            Row{
                Text(text = "No.${landmark.id}:${landmark.name}", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.weight(1f))
                FavoriteStar(isFavoriteData = favoriteData)
            }
            Text(text = landmark.description,style = MaterialTheme.typography.bodyLarge)
            }
    }



@Preview(showBackground = true)
@Composable
fun ListItemPreview() {
   JetpackListTheme {
       ListItem(landmark = LandmarkData(
           1,
           stringResource(id = R.string.landmark_name),
           "this is sample.\n" + stringResource(id = R.string.description),
           stringResource(id = R.string.airport),
       ),
           favoriteData = false,
           navController = NavController(LocalContext.current)
       )
   }
}


