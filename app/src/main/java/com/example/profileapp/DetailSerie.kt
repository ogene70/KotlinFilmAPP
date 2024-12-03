package com.example.profileapp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController

@Composable
fun DetailSerieView(viewModel: MainViewModel,navController: NavController,id:Int){
    val serie by viewModel.detailSerie.collectAsState()
    LaunchedEffect(id) {viewModel.fetchDetailSerie(id)}

    if (serie==null){
        Text(text = "Pas de détails pour ce film")
    }else{LazyColumn {
        item {
            Text(text = "${serie?.name}")
        }
        item {  }

    }}



}