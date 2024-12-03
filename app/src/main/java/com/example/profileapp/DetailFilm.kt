package com.example.profileapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import org.w3c.dom.Text

@Composable
fun DetailFilmView(viewModel: MainViewModel,navController: NavController,id:Int){
    val film by viewModel.detailFilm.collectAsState()
    LaunchedEffect(id) {viewModel.fetchDetailFilm(id)}



    if (film==null){
        Text(text = "Pas de détails pour ce film")
    }else{LazyColumn {
        item {
            Text(text = "${film?.original_title}")
        }


    }}

}