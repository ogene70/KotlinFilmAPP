package com.example.profileapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedCard
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import android.util.Log
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.LaunchedEffect
import moviesByDefault

@Composable
fun Films(viewModel: MainViewModel){

val movies by viewModel.movies.collectAsState()
LaunchedEffect(true) {viewModel.fetchMovies()}


    Column {
    if (movies.isEmpty()){
        Text(text = "Composant movies est vide $movies")


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

                items(movies.size){
                        index ->
                    OutlinedCard() {

                        Column() {
                            Text(text="${movies[index].original_title}")
                            AsyncImage(
                                model = "https://image.tmdb.org/t/p/w780/${movies[index].backdrop_path}",
                                contentDescription = "Image du film ${movies[index].original_title}",
                                onError = {
                                    Log.e("ImageLoadError", it.result.throwable.message ?: "Unknown error")
                                }
                            )
                            Text(text ="${movies[index].release_date}" )

                        }
                    }

                }
            })
    }



}


}