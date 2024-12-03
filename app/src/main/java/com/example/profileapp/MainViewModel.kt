package com.example.profileapp

import Movies
import Series
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class MainViewModel: ViewModel(){
    val movies = MutableStateFlow<List<Movies>>(listOf())
    val series= MutableStateFlow<List<Series>>(listOf())

    private val apiKey="74f62967e1525b5b18ada01dc9f61467";

    val service=Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(TmdbAPI ::class.java)

     fun fetchMovies(){
        viewModelScope.launch {
            try {
                movies.value = service.getFilm(apiKey).results
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    fun fetchSeries(){
        viewModelScope.launch {
            try {
                series.value = service.getSerie(apiKey).results
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}