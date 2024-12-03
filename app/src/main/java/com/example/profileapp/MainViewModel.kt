package com.example.profileapp

import DetailFilm
import DetailSerie
import Movies
import Series
import android.util.Log
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
    val detailSerie= MutableStateFlow<DetailSerie?>(null)
    val detailFilm=MutableStateFlow<DetailFilm?>(null)

     val apiKey="74f62967e1525b5b18ada01dc9f61467";

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
    fun fetchDetailSerie(id:Int){
        Log.v("serie","appelFecthD")
            viewModelScope.launch {
                try {
                    detailSerie.value= service.getDetailSerie(id,apiKey)
                    Log.v("serie",detailSerie?.value?.name?:"")
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }


    }
    fun fetchDetailFilm(id:Int){
        Log.v("serie","appelFecthD")
        viewModelScope.launch {
            try {
                detailFilm.value= service.getDetailFilm(id,apiKey)
                Log.v("serie",detailSerie?.value?.name?:"")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


    }

}