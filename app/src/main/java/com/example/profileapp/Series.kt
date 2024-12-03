package com.example.profileapp

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import coil.compose.AsyncImage
import moviesByDefault
@Composable
fun Series(viewModel: MainViewModel,navController:NavHostController){
    val series by viewModel.series.collectAsState()
    LaunchedEffect(true) {viewModel.fetchSeries()}

    Column {
        if (series.isEmpty()){
            Text(text = "Composant serie est vide $series")


            LazyVerticalGrid  (
                columns = GridCells.Fixed(2),
                content = {

                    items(moviesByDefault.size){
                            index ->
                        OutlinedCard() {

                            Column() {
                                Text(text="${moviesByDefault[index].original_title}")
                                AsyncImage(
                                    model = "https://image.tmdb.org/t/p/w780/${moviesByDefault[index].img_link}",
                                    contentDescription = "Image du film ${moviesByDefault[index].original_title}",
                                    onError = {
                                        Log.e("ImageLoadError", it.result.throwable.message ?: "Unknown error")
                                    }
                                )

                            }
                        }

                    }
                })



        }else{
            LazyVerticalGrid  (columns = GridCells.Fixed(2),
                content = {

                    items(series.size){
                            index ->
                        OutlinedCard(
                            onClick = {
                                navController.navigate(DetailSerieDestination(series[index].id))
                            }
                        ) {

                            Column() {
                                Text(text="${series[index].name}")
                                AsyncImage(
                                    model = "https://image.tmdb.org/t/p/w780/${series[index].backdrop_path}",
                                    contentDescription = "Image du film ${series[index].name}",
                                    onError = {
                                        Log.e("ImageLoadError", it.result.throwable.message ?: "Unknown error")
                                    }
                                )
                                Text(text ="${series[index].first_air_date}" )

                            }
                        }

                    }
                })
        }



    }

}