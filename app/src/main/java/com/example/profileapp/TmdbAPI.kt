package com.example.profileapp

import TmdBSerieResults
import TmdbResults
import retrofit2.http.GET
import retrofit2.http.Query


interface TmdbAPI{
    @GET("trending/movie/week")
    suspend fun getFilm(@Query("api_key") apiKey: String):TmdbResults

    @GET("trending/tv/week")
    suspend fun getSerie(@Query("api_key") api_key:String):TmdBSerieResults

}



