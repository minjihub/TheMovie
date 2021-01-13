package com.example.themovie.service

import com.example.themovie.model.MovieData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MovieService {

    @GET("discover/movie")
    fun getTop(@QueryMap par: Map<String, String>): Call<MovieData>

}