package com.example.profileapp

import DetailFilm
import DetailSerie
import TmdBSerieResults
import TmdbResults
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface TmdbAPI{





    @GET("trending/movie/week")
    suspend fun getFilm(@Query("api_key") apiKey: String):TmdbResults

    @GET("trending/tv/week")
    suspend fun getSerie(@Query("api_key") api_key:String):TmdBSerieResults


    @GET("tv/{id}?append_to_response=credits")
    suspend fun getDetailSerie(@Path("id") id_serie:Int,@Query("api_key") api_key:String):DetailSerie

    @GET("movie/{id}?append_to_response=credits")
    suspend fun getDetailFilm(@Path("id") id_film:Int , @Query("api_key") api_key:String):DetailFilm


    @Get("")
}



